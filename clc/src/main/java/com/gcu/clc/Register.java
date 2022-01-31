package com.gcu.clc;

import java.util.ArrayList;

public class Register {
    private String username;
    private String password;
    public static ArrayList<String> SavedUsers = new ArrayList<String>();
    public static ArrayList<String> SavedPassword = new ArrayList<String>();

    public Register(){
        super();
    }
    
    public Register(String username, String password){
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


    //Collect the User Cred
    public void addUsername(){
        SavedUsers.add(username);
    }

    public void addPassword(){
        SavedPassword.add(password);
    }

    public void addCred(){
        addUsername();
        addPassword();
    }
}
