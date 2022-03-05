package com.gcu.clc.business;

import com.gcu.clc.data.RegisterDataService;
import com.gcu.clc.model.RegistrationModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RegistrationBusinessService
 */
// @Service
public class RegistrationBusinessService {
    @Autowired
    RegisterDataService service;

    public UserModel createAccount(RegistrationModel user){
        return service.createUser(user);
    }

    public void init() {
        System.out.println("Initializing RegistrationBusinessService");
    }

    public void destroy() {
        System.out.println("Destroying RegistrationBusinessService");
    }
}