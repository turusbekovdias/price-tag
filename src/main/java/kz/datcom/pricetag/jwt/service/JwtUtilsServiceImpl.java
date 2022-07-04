package kz.datcom.pricetag.jwt.service;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Key;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JwtUtilsServiceImpl implements JwtUtilsService {

    private Key publicKey;

    public JwtUtilsServiceImpl()
            throws FileNotFoundException, CertificateException {
        File publicKeyFile = ResourceUtils.getFile("classpath:jwt/cert.pem");

        CertificateFactory fact = CertificateFactory.getInstance("X.509");
        FileInputStream is = new FileInputStream(publicKeyFile.toPath().toFile());
        X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
        this.publicKey = cer.getPublicKey();
    }

    @Override
    public boolean validateToken(String authToken) {
        try {
            // Jwt token has not been tampered with
            Jws<Claims> claims = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
        }
    }

    @Override
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    @Override
    public List<SimpleGrantedAuthority> getRolesFromToken(String authToken) {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        Claims claims = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(authToken).getBody();
        if (claims.get("roles") == null)
            throw new BadCredentialsException("ROLES_NOT_PRESENT");

        log.info("Found roles " + claims.get("roles") + ".");
        for (String role : (List<String>) claims.get("roles")) {
            log.info("role: " + role);
            roles.add(new SimpleGrantedAuthority(role.startsWith("ROLE_") ?
                    role.toUpperCase() : ("ROLE_" + role).toUpperCase()));
        }
        return roles;
    }

    @Override
    public ObjectId getAccountIdFromToken(String authToken) {
        Claims claims = Jwts.parser().setSigningKey(this.publicKey).parseClaimsJws(authToken).getBody();
        if (claims.get("id") == null)
            throw new BadCredentialsException("ID_NOT_FOUND");

        return new ObjectId(claims.get("id").toString());
    }

}
