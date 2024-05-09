package com.dbl.aquilashipyard.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI().info(
                new Info().description("Apis for Aquila-Shipyard")
                        .version("1.0.0")
                        .title("Aquila-Shipyard")
        );
    }
}