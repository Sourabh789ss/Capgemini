package com.javaexcel.usermicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class UsermicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermicroservicesApplication.class, args);
        System.out.println("@@UserApp Started");
    }

    //Rest Template

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
