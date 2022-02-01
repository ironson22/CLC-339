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
    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseTime() {
        return this.purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
