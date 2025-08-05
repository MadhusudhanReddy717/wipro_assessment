package com.javaconceptoftheday;

import org.springframework.stereotype.Component;

@Component("classABC")
public class ClassABC implements InterfacePQR {
    public void display() {
        System.out.println("Hi...I am ClassABC");
    }
}