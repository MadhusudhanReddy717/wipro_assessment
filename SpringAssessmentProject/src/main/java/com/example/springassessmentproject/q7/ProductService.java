package com.example.springassessmentproject.q7;

public class ProductService {
    private ProductDao dao;

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public Product getProductDetails(int product_code) {
        return dao.getProductDetails(product_code);
    }

    public double calculatePrice(int quantity, double product_price) {
        return quantity * product_price;
    }

    public boolean validateProductCode(int product_code) {
        return product_code > 0 && String.valueOf(product_code).length() == 4;
    }

    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
