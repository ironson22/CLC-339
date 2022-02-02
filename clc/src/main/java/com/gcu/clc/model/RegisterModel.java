package com.gcu.clc.model;

import java.util.ArrayList;

public class RegisterModel {
    private String username;
    private String password;
    public static ArrayList<String> savedUsers = new ArrayList<String>();
    public static ArrayList<String> savedPassword = new ArrayList<String>();
    
    public RegisterModel(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }

    //Getters for private Strings
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    //setter for the private Strings
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }



}
