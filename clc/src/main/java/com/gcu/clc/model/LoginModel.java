package com.gcu.clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginModel {
    @NotNull
    @Size(min = 1, max = 100, message = "You must enter your email")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    @NotNull
    @Size(min = 6, max = 32, message = "You must enter your password")
    private String password;

    
    /** 
     * a getter for the email
     * @return the user email
     */
    public String getEmail(){
        return email;
    }

    
    /** 
     * the getter for the password of the user
     * @return the user password
     */
    public String getPassword(){
        return password;
    }

    
    /** 
     * A setter for the email
     * @param email the email of a user
     */
    public void setEmail(String email){
        this.email = email;
    }

    
    /** 
     * A setter for the password
     * @param password The password of a user
     */
    public void setPassword(String password){
        this.password = password;
    }
}
