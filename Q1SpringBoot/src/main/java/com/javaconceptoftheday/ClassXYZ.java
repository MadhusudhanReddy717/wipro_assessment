package com.javaconceptoftheday;

import org.springframework.stereotype.Component;

@Component("classXYZ")
public class ClassXYZ implements InterfacePQR {
    public void display() {
        System.out.println("Hi...I am ClassXYZ");
    }
}
