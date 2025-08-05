package com.javaconceptoftheday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q1MainApp implements CommandLineRunner {

    @Autowired
    private ClassKLM klm;

    public static void main(String[] args) {
        SpringApplication.run(Q1MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        klm.printMessage();
    }
}
