package kz.datcom.starterproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@RefreshScope
@Configuration
@OpenAPIDefinition(info = @Info(title = "Datcom ____ Service API", version = "v1"))
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {

    @Value("${application.gateway-port-ext}")
    private String gatewayPort;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String applicationPort;
    @Value("${server.host:localhost}")
    private String applicationHost;

    @Bean
    @Profile("dev")
    public OpenAPI openAPIDev() {
        URIBuilder swaggerUriBuilder = new URIBuilder().setScheme("http")
                .setHost(applicationHost)
                .setPort(Integer.parseInt(gatewayPort))
                .setPathSegments(applicationName);

        URIBuilder localhostUriBuilder = new URIBuilder().setScheme("http")
                .setHost(applicationHost)
                .setPort(Integer.parseInt(applicationPort));

        return new OpenAPI()
                .addServersItem(new Server().url(localhostUriBuilder.toString()).description("Localhost"))
                .addServersItem(new Server().url(swaggerUriBuilder.toString()).description("Localhost Gateway"));
    }

    @Bean
    @Profile("test || devserver")
    public OpenAPI openAPITest() {

        URIBuilder remoteTestUriBuilder = new URIBuilder().setScheme("http")
                .setHost(applicationHost)
                .setPort(Integer.parseInt(gatewayPort))
                .setPathSegments(applicationName);;

        return new OpenAPI()
                .addServersItem(new Server().url(remoteTestUriBuilder.toString()).description("Test server Gateway"));
    }
}
