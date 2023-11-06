package com.midas.market.config.SpringDoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Midas Market")
                        .description("API Rest de la aplicación Midas Market, que contiene las funcionalidades de CRUD de Productos, sumandole autenticacion" +
                                "registro y autenticacion de usuarios")
                        .contact(new Contact()
                                .name("Equipo Backend")
                                .email("rodrigourq@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://midas_market/api/productos")));  }

    @Bean
    public void message(){
        System.out.println("Bearer is working");
    }

}