package com.javaconceptoftheday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC")
    private InterfacePQR pqr;

    public void printMessage() {
        pqr.display();
    }
}
