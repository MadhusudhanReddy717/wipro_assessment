package com.example.springassessmentproject.q3;

import org.springframework.beans.factory.annotation.Autowired;

public class Freshman {
    private String name;

    @Autowired
    private DormRoom room;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room.getLocation();
    }

    public void display() {
        System.out.println("Freshman Name: " + getName());
        System.out.println("Dorm Location: " + getRoom());
    }
}
