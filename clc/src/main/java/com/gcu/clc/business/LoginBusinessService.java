package com.gcu.clc.business;

import javax.validation.constraints.Email;

/**
 * LoginBusinessService
 */
public class LoginBusinessService {
    private static String email;
    private static String password;
    /**
     * email getter
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * password getter
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    public void init() {
        System.out.println("Initializing LoginBusinessService");
    }

    public void destroy() {
        System.out.println("Destroying LoginBusinessService");
    }
}