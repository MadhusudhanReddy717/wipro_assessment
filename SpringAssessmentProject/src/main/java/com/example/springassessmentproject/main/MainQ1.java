package com.example.springassessmentproject.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.springassessmentproject.bean.Q1Component;

public class MainQ1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.example.springassessmentproject.bean");

        Q1Component comp = context.getBean(Q1Component.class);
        comp.printProperties();

        context.close();
    }
}
/*
URL: http:arunatirupalu@gmail.com
Username: Madhu
Password: password123
*/