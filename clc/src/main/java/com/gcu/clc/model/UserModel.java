package com.gcu.clc.model;

public class UserModel {
    private int userId;
    private String name;
    private String phoneNumber;
    private String email;
    private String profileImage;
    private String address;

    public UserModel(int userId, String name, String phoneNumber, String email, String profileImage, String address){
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profileImage = profileImage;
    }
    public int getUser_id() {
        return this.userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhonNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
