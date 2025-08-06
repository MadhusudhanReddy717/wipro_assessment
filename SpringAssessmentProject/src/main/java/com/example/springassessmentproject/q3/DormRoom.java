package com.example.springassessmentproject.q3;

public class DormRoom {
    private int number;
    private String building;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getLocation() {
        return building + " - Room " + number;
    }
}
