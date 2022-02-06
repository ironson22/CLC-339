package com.gcu.clc.model;

public class OrdersModel {
    private String purchaseDate;
    private String purchaseTime;
    private int userId;
    private int productId;

    public OrdersModel(String purchaseDate, String purchaseTime, int userId, int productId){
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.userId = userId;
        this.productId = productId;
    }
    
    /** 
     * A getter for the date
     * @return the date of the purchase
     */
    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    
    /** 
     * A setter for the date
     * @param purchaseDate the date of the purchase
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    
    /** 
     * A getter for the time of purchase
     * @return the time of purchase
     */
    public String getPurchaseTime() {
        return this.purchaseTime;
    }

    
    /** 
     * A setter for the time of purchase
     * @param purchaseTime the time of purchase
     */
    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    
    /** 
     * The getter of the User ID
     * @return the id of a user
     */
    public int getUserId() {
        return this.userId;
    }

    
    /** 
     * A setter of the User ID
     * @param userId the id of a user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    /** 
     * The getter of the product ID
     * @return the product ID
     */
    public int getProductId() {
        return this.productId;
    }

    
    /** 
     * A setter of the product ID
     * @param productId the product ID
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

}
