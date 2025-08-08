package com.spring.q3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class Q3MainApp {

    public static void main(String[] args) {
        SpringApplication.run(Q3MainApp.class, args);

        try {
            String url = "http://localhost:8081";
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(url));
                } else {
                    System.out.println("BROWSE action not supported.");
                }
            } else {
                System.out.println("Desktop is not supported.");
            }
        } catch (Exception e) {
            System.out.println("Couldn't open browser automatically: " + e.getMessage());
        }
    }
}

