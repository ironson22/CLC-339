package com.gcu.clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationModel {
    @NotNull(message = "First name is a required field")
    @Size(min = 3, max = 32, message = "First name must be between 2 and 32 characters")
    private String firstName;

    @NotNull(message = "First name is a required field")
    @Size(min = 3, max = 32, message = "First name must be between 2 and 32 characters")
    private String lastName;

    //1234567890, 123-456-7890, (123)456-7890, (123)4567890
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")
    private String phoneNumber;

    @NotNull(message = "Email is a required field")
    @Size(min = 6, max = 32, message = "email must be between 1 and 32")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull(message = "Password is a required field")
    @Size(min = 6, max = 32, message = "password must be between 6 and 32 characters")
    private String password;
    @NotNull
    @Size(min = 8, max = 50)
    private String address;

    public RegistrationModel() {
        this.email = "";
        this.password = "";
    }

    /**
     * 
     * @param email The user's email that was entered in the registration
     * @param password The user's password that was entered in the registration
     * @param firstName The user's first name that was entered in the registration
     * @param lastName The user's last name that was entered in the registration
     * @param phoneNumber The user's phone number that was entered in the registration
     */
    public RegistrationModel(String email, String password, String firstName, String lastName, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * first name getter
     * @return the first name of the user
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * first name setter
     * @param firstName sets the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * last name getter
     * @return gets the last name of the user
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * setter last name
     * @param lastName sets the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * email getter
     * @return the email of the user
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * sets the email
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * phone number getter
     * @return the phone number of the user
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    /**
     * phone number setter
     * @param phoneNumber the phone number of the user
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
/**
 * 
 * @return user's address
 */
    public String getAddress() {
        return this.address;
    }
/**
 * user's address
 * @param address
 */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * password getter
     * @return password of the user
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * password setter
     * @param password password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}