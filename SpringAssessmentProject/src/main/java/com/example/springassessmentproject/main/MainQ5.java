package com.example.springassessmentproject.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.springassessmentproject.q5.Item;
import com.example.springassessmentproject.q5.AppConfig;

public class MainQ5 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Item item = context.getBean(Item.class);
        item.display();
    }
}
/*
Item ID: 101
Item Name: BMW
Item Price: 5000000.0
Category ID: 501
Category Name: Car
*/