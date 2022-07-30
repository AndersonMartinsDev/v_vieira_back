package com.vvieira.app.auth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Data
@Configuration
public class Config implements WebMvcConfigurer {

    @Value("${project.version}")
    private String projectVersion;

    @Value("${project.name}")
    private String projectName;

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*/**")
                .allowedMethods("HEAD","OPTIONS","GET","POST","DELETE","PUT")
                .allowedHeaders("*");
    }
}
