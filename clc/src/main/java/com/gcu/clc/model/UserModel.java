package com.gcu.clc.model;

public class UserModel {
    private Long userId;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    private String profileImage;
    private String address;
    private boolean loggedIn;
    
    /** 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /** 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * @return String
     */
    public String getProfileImage() {
        return this.profileImage;
    }


    
    /** 
     * @return boolean
     */
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    
    /** 
     * @return boolean
     */
    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    
    /** 
     * @param loggedIn
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public UserModel(Long userId, String firstName, String lastName, String password, String phoneNumber, String email, String profileImage, String address){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profileImage = profileImage;
    }
    
    
    /** 
     * A getter for the user ID
     * @return the ID of the user
     */
    public Long getUserId() {
        return this.userId;
    }

    
    /** 
     * Sets the ID of the user
     * @param userId the user ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    
    /** 
     * Getter for the name of a user
     * @return gets the value of name of the user
     */
    public String getFirstName() {
        return this.firstName;
    }

    
    /** 
     * @param name the name of the user
     */
    public void setName(String firstName) {
        this.firstName = firstName;
    }

    /** 
     * Getter for the name of a user
     * @return gets the value of name of the user
     */
    public String getLastName() {
        return this.lastName;
    }

    
    /** 
     * @param name the name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
