package com.gcu.clc.model;

import java.util.Locale.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class ProductModel {
    // private int productId;
    @NotNull
    @Size(min=5, max = 50)
    private String productName;
    @NotNull
    // @Size(min=1)
    // private String productImage;
    @NotNull
    private String category;
    private String description;
    @NotNull
    @NumberFormat
    private float price;

    public ProductModel(){
        this.productName = "";
        this.description = "";
        this.price = 0;
        // this.productImage = "";
    }
    public ProductModel(String productName, String description, String category, float price){
        this.productName = productName;
        this.description = description;
        this.price = price;
        // this.productImage = productImage;
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
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
