package com.example.q20gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Q20GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Q20GatewayApplication.class, args);
    }
}
//http://localhost:8080/employee/info