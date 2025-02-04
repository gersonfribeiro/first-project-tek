package com.example.demo.config.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Classe de configuração para a documentação da API utilizando Swagger.
 * A documentação pode ser acessada pelo link: http://localhost:8080/swagger-ui/index.html#/
 */
@Configuration  // Indica que esta classe contém configurações de aplicação
public class SwaggerConfig {

    /**
     * Método que cria e configura um objeto OpenAPI com informações da API.
     *
     * @return Um objeto OpenAPI contendo as informações da API.
     */
    // Indica que este método retorna um bean gerenciado pelo Spring
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()  // Cria uma nova instância de Info para definir os metadados da API
                        .title("Spring Boot REST API")  // Define o título da API
                        .description("Demo")  // Descrição da API
                        .version("1.0.0"))  // Define a versão da API
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("BearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
