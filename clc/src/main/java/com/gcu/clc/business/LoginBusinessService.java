package com.gcu.clc.business;

import javax.validation.constraints.Email;

/**
 * LoginBusinessService
 */
public class LoginBusinessService {
    private static String email;
    private static String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static void setEmail(String email) {
        LoginBusinessService.email = email;
    }

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