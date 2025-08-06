package com.example.springassessmentproject.main;

import com.example.springassessmentproject.q8.ShoppingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainQ8 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q8-aop-config.xml");
        ShoppingService shoppingService = context.getBean("shoppingService", ShoppingService.class);
        shoppingService.addToCart("Tata Harrier");
        shoppingService.makePayment(2500000);
        shoppingService.placeOrder();
    }
}
