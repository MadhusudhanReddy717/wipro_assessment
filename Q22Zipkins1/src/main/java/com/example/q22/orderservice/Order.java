package com.example.q22.orderservice;

public class Order {
    private Long id;
    private String itemName;
    private int quantity;

    public Order(Long id, String itemName, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
}
