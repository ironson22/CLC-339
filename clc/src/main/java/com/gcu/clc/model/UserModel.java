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
    
    /** 
     * A getter for the user ID
     * @return the ID of the user
     */
    public int getUser_id() {
        return this.userId;
    }

    
    /** 
     * Sets the ID of the user
     * @param userId the user ID
     */
    public void setUser_id(int userId) {
        this.userId = userId;
    }

    
    /** 
     * Getter for the name of a user
     * @return gets the value of name of the user
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param name the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * A getter for the phone number of a user
     * @return the phone number of the user
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    
    /** 
     * @param phoneNumber the phone number of the user
     */
    public void setPhonNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * A getter for the email of a user
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    
    /** 
     * Setter for the email of a user
     * @param email The email of a user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return The profile Image a user is using
     */
    public String getProfilImage() {
        return this.profileImage;
    }

    
    /** 
     * A setter for the user
     * @param profileImage The profile image a user is using
     */
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    
    /** 
     * A getter for the address
     * @return the address of a user
     */
    public String getAddress() {
        return this.address;
    }

    
    /** 
     * A setter for the address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
