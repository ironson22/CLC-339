package com.gcu.clc.business;

import com.gcu.clc.data.RegisterDataService;
import com.gcu.clc.model.RegistrationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegistrationBusinessService
 */
public class RegistrationBusinessService {
    @Autowired
    RegisterDataService service;
    public void createAccount(RegistrationModel user){
        service.createUser(user);
    }

    // private String email = "";
    // private String password = "";
    // private String firstName = "";
    // private String lastName = "";
    // private String phoneNumber = "";

    // public String getEmail() {
    //     return this.email;
    // }

    // public void setEmail(String inEmail) {
    //     this.email = inEmail;
    //     LoginBusinessService.setEmail(email);
    // }

    // public String getPassword() {
    //     return this.password;
    // }

    // public void setPassword(String inPassword) {
    //     this.password = inPassword;
    //     LoginBusinessService.setPassword(password);
    // }

    // public String getFirstName() {
    //     return this.firstName;
    // }

    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // public String getLastName() {
    //     return this.lastName;
    // }

    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }

    // public String getPhoneNumber() {
    //     return this.phoneNumber;
    // }

    // public void setPhoneNumber(String phoneNumber) {
    //     this.phoneNumber = phoneNumber;
    // }

    public void init() {
        System.out.println("Initializing RegistrationBusinessService");
    }

    public void destroy() {
        System.out.println("Destroying RegistrationBusinessService");
    }
}