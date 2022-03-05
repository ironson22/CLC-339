package com.gcu.clc.business;

import com.gcu.clc.data.LoginDataService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * LoginBusinessService
 */
public class LoginBusinessService {
    @Autowired
    LoginDataService service;

    public UserModel authenticateAccount(LoginModel user){
        return service.authenticateUser(user);
    }
    
    public void init() {
        System.out.println("Initializing LoginBusinessService");
    }

    public void destroy() {
        System.out.println("Destroying LoginBusinessService");
    }
}