package com.cafeto.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Swagger Configuration Documentation for microservices
 * @author Edwin Hidalgo
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Set<String> DEFAULT_PRODUCES = new HashSet<>(List.of("application/json"));
    private static final Set<String> DEFAULT_CONSUMES = new HashSet<>(List.of("application/json"));

    private static final String OWNER = "ehidalgo49@hotmail.com";
    private static final Contact CONTACT = new Contact("Edwin Hidalgo", OWNER, OWNER);
    private static final ApiInfo API_INFO = new ApiInfo("Cafeto API",
            "Application test for Cafeto", "1.0", "",
            CONTACT, "Apache", OWNER, new ArrayList<>());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO).produces(DEFAULT_PRODUCES)
                .consumes(DEFAULT_CONSUMES);
    }
}