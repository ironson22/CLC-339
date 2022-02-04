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

    public LoginModel(){
        this.email = "";
        this.password = "";
    }

    public LoginModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    //Getters for private Strings
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    //setter for the private Strings
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
