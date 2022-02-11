package com.gcu.clc.model;

public class ProductModel {
    private int productId;
    private String productName;
    private String productImage;

    private String description;
    private float price;

    public ProductModel(int productId, String productName, String description, String productImage, float price){
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
    }

    /**
     * 
     * @return the pathway for the product image used in the html file
     */
    public String getProductImage() {
        return this.productImage;
    }
    /**
     * sets the image of the product
     * @param productImage the image of the product
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /** 
     * A getter for the product
     * @return The product ID
     */
    public int getProductId() {
        return this.productId;
    }

    
    /** 
     * A setter for the product
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    
    /** 
     * A getter for the product name
     * @return The product name
     */
    public String getProductName() {
        return this.productName;
    }

    
    /** 
     * A setter for the product name
     * @param productName The product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    /** 
     * A getter for the description of a product
     * @return The description of a product
     */
    public String getDescription() {
        return this.description;
    }

    
    /** 
     * A setter for the description
     * @param description The description for the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /** 
     * A getter for the price
     * @return The price of a product
     */
    public float getPrice() {
        return this.price;
    }

    
    /** 
     * A setter for the price
     * @param price The price of a product
     */
    public void setPrice(float price) {
        this.price = price;
    }


}
