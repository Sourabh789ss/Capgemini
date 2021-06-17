package com.javaexcel.booking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket swaggerApiConifg(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/book/**"))
                .apis(RequestHandlerSelectors.basePackage("com.javaexcel.booking"))
                .build()
                .apiInfo(apiDetails());

    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Flight Booking API",
                "Case Study for Javaexcel project",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Sourabh Sharma", "http://javaexcel.com","sourabh789.ss@gmail.com"),
                "API License",
                "http://javaexcel.com",
                Collections.emptyList()
        );
    }
}
