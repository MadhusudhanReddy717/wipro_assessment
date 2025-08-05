package com.q2.propertiesdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Q2MainApp implements CommandLineRunner {

    @Autowired
    private PropertyInjection injection;

    public static void main(String[] args) {
        SpringApplication.run(Q2MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        injection.printValues();
    }
}
