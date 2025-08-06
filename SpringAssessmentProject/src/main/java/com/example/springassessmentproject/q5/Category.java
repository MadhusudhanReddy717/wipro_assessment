package com.example.springassessmentproject.q5;

import org.springframework.stereotype.Component;

@Component
public class Category {
    private int categoryId = 501;
    private String categoryName = "Car";

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
