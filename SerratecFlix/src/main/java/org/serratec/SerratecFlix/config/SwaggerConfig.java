package org.serratec.SerratecFlix.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API - SERRATEC FLIX")
                .version("1.0")
                .description("API RESTful para gerenciamento de avaliacoes de filmes e series")
                .contact(new Contact().name("Igor, Bruno, Wallace e Kenny")
                        .email("residencia_sw@serratec.org")
                        .url("https://serratec.org"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
