package com.example.springassessmentproject.q9;

public class Purchase {
    private int purchaseId;
    private String purchaseDate;
    private Product product;

    public Purchase(int purchaseId, String purchaseDate, Product product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.product = product;
    }

    public void displayDetails() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Product Price: " + product.getPrice());
        System.out.println("Created by Madhusudhan Reddy");
    }
}
