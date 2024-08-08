package com.kentidev.inventory_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Inventory Service API")
                        .description("This is the rest api for inventory service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }
}
