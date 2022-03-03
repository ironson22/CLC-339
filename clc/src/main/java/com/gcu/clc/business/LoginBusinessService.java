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
    /**
     * email setter
     * @param email the email
     */
    public static void setEmail(String email) {
        LoginBusinessService.email = email;
    }
    /**
     * password setter
     * @param password the password
     */
    public static void setPassword(String password) {
        LoginBusinessService.password = password;
    }
    
    public void init() {
        System.out.println("Initializing LoginBusinessService");
    }

    public void destroy() {
        System.out.println("Destroying LoginBusinessService");
    }
}