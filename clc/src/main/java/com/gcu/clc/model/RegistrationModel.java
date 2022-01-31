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

    // @Size(min = 1, max = 32, message = "Username must be between 1 and 32")
    // @Pattern(regexp = "/^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$/")
    // private String phone_number;
    // @NotNull(message ="Username is a required field")
    // @Size(min = 1, max = 32, message = "email must be between 1 and 32")
    // @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    // private String email;
    // @NotNull(message ="Username is a required field")
    // @Size(min = 1, max = 32, message = "Address must be between 1 and 32 characters")
    // private String password;


    public String getfirstName() {
        return this.firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return this.lastName;
    }

    public void setLname(String lastName) {
        this.lastName = lastName;
    }
}
