package com.example.q22.paymentservice;

public class Payment {
    private Long id;
    private double amount;
    private String status;

    public Payment(Long id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
