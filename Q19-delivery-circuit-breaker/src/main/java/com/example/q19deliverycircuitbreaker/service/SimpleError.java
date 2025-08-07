package com.example.q19deliverycircuitbreaker.service;

public class SimpleError {
    private String message;

    public SimpleError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
