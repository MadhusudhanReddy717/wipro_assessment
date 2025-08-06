package com.example.springassessmentproject.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.springassessmentproject.q2.Account;

public class MainQ2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q2-config.xml");
        
        Account account = (Account) context.getBean("accountBean");
        account.printAccountDetails();
    }
}
/*
Account Number: 10001
Account Holder: Madhusudhan Reddy
Balance: Rs. 75000.5
Bank ID: 101
Bank Name: State Bank of India
*/