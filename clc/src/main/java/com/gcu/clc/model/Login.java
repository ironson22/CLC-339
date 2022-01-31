package com.gcu.clc.model;

public class Login {
    private String username;
    private String password;

    public Login(){
        super();
    }
    
    public Login(String username, String password){
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
