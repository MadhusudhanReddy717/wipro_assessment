package com.example.springassessmentproject.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.springassessmentproject.q4.Account;

public class MainQ4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q4-config.xml");
        Account account = (Account) context.getBean("accountBean");
        account.display();
    }
}
/*
Account Number: 97865432
Account Holder: Madhusudhan Reddy
Balance: 75000.25
Account Type: Savings
*/