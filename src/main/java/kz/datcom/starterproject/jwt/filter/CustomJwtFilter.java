package kz.datcom.starterproject.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import kz.datcom.starterproject.jwt.service.JwtUtilsService;
import kz.datcom.starterproject.model.token.UsernameIdPasswordAuthenticationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomJwtFilter implements WebFilter {

    private final JwtUtilsService jwtTokenUtil;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        log.info("Hit the filter!");
        String jwtToken = this.extractJwtFromRequest(serverWebExchange.getRequest().getHeaders());

        try {
            if (StringUtils.hasText(jwtToken) && jwtTokenUtil.validateToken(jwtToken)) {
                String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                log.info("User logged in: " + username);
                UserDetails userDetails = new User(username, "", jwtTokenUtil.getRolesFromToken(jwtToken));

                UsernameIdPasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernameIdPasswordAuthenticationToken(
                                userDetails, jwtTokenUtil.getAccountIdFromToken(jwtToken), null, userDetails.getAuthorities());

                return webFilterChain.filter(serverWebExchange)
                        .subscriberContext(context -> ReactiveSecurityContextHolder.withAuthentication(usernamePasswordAuthenticationToken))
                        .onErrorResume(AuthenticationException.class, e -> {
                            log.error("Authentication Exception", e);
                            return webFilterChain.filter(serverWebExchange);
                        });
            }
        } catch (ExpiredJwtException | BadCredentialsException ex) {
            serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return write(serverWebExchange.getResponse(), ex.getMessage());
        }

        return webFilterChain.filter(serverWebExchange);
    }

    public <T> Mono<Void> write(ServerHttpResponse httpResponse, T object) {
        return httpResponse
                .writeWith(Mono.fromSupplier(() -> {
                    DataBufferFactory bufferFactory = httpResponse.bufferFactory();
                    try {
                        return bufferFactory.wrap(objectMapper.writeValueAsBytes(object));
                    } catch (Exception ex) {
                        log.warn("Error writing response", ex);
                        return bufferFactory.wrap(new byte[0]);
                    }
                }));
    }

    private String extractJwtFromRequest(HttpHeaders headers) {
        if (headers == null || headers.get("Authorization") == null) return null;
        String bearerToken = headers.get("Authorization").get(0);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
