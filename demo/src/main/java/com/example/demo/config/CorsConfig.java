package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // Cambia la URL al dominio que necesites permitir.
                        .allowedOrigins("https://carlos1ab1.github.io")
                        // Otras opciones posibles: "http://localhost:3000", etc.
                        .allowedMethods("*")     // GET, POST, PUT, DELETE, etc.
                        .allowedHeaders("*")     // Permite cualquier header
                        .allowCredentials(true); // Permite el uso de cookies o credenciales
            }
        };
    }
}
