package com.gcu.clc.model;

public class ProductModel {
    private int productId;
    private String productName;
    private String description;
    private float price;

    public ProductModel(int productId, String productName, String description, float price){
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
