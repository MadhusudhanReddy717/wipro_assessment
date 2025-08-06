package com.example.springassessmentproject.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:datafile.properties")
public class Q1Component {

    @Value("${URL}")
    private String url;

    @Value("Madhu")
    private String username;

    @Value("${password}")
    private String password;

    public void printProperties() {
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
