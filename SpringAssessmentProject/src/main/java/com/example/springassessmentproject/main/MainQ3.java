package com.example.springassessmentproject.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.springassessmentproject.q3.Freshman;

public class MainQ3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q3-config.xml");
        Freshman freshman = (Freshman) context.getBean("freshman");
        freshman.display();
    }
}
/*
Freshman Name: Madhusudhan Reddy
Dorm Location: North Hall - Room 101
*/