package com.gcu.clc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationModel {
    @NotNull(message ="First name is a required field")
    @Size(min = 6, max = 32, message = "First name must be between 2 and 32 characters")
    private String firstName;

    @NotNull(message ="First name is a required field")
    @Size(min = 6, max = 32, message = "First name must be between 2 and 32 characters")
    private String lastName;

    @Size(min = 1, max = 32, message = "Username must be between 1 and 32")
    @Pattern(regexp = "/^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$/")
    private String phoneNumber;

    @NotNull(message ="Username is a required field")
    @Size(min = 1, max = 32, message = "email must be between 1 and 32")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull(message ="Password is a required field")
    @Size(min = 1, max = 32, message = "password must be between 6 and 32 characters")
    private String password; 

    public RegistrationModel(){
        this.email = "";
        this.password = "";
    }

    public RegistrationModel(String email, String password){
        this.email = email;
        this.password = password;
    }

    
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public String getfirstName() {
    //     return this.firstName;
    // }

    // public void setfirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // public String getlastName() {
    //     return this.lastName;
    // }

    // public void setLname(String lastName) {
    //     this.lastName = lastName;
    // }
}
