package com.example.demo;

import com.example.demo.error.RestTemplateResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Q16RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Q16RestTemplateApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.setErrorHandler(new RestTemplateResponseErrorHandler());
        return rt;
    }
}
//http://localhost:8080/api/posts