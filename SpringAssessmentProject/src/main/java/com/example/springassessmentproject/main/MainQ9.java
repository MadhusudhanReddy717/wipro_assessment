package com.example.springassessmentproject.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.springassessmentproject.q9.Purchase;

public class MainQ9 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q9config.xml");
        Purchase purchase = (Purchase) context.getBean("purchase");
        purchase.displayDetails();
    }
}
/*
Purchase ID: 9001
Purchase Date: 2025-08-06
Product ID: 1001
Product Name: Laptop
Product Price: 65000.0
Created by Madhusudhan Reddy
*/