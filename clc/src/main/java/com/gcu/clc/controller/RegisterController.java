package com.gcu.clc.controller;


import javax.validation.Valid;

import com.gcu.clc.business.RegistrationBusinessService;
import com.gcu.clc.model.RegistrationModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegisterController {
    @Autowired
    private RegistrationBusinessService register;
    /** 
     * @param model The model to be used
     * @return Returns the file that the user will be taken to
     */
    @GetMapping("/")
    public String showRegister(Model model){
        model.addAttribute("title", "Registration");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "register";
    }
    
    /** 
     * @param signUp the RegisterationModel being used
     * @param bindResult Used to determine errors
     * @param model The model being used
     * @return Returns the file that the user will be taken to
     */
    @PostMapping("/register")
    public String register(@Valid RegistrationModel signUp, BindingResult bindResult, Model model) {
        //If there were errors, it'll take the user to the registration page again
        if(bindResult.hasErrors()){
            model.addAttribute("title", signUp.getFirstName());
            return "register";
        }
        
        register.setEmail(signUp.getEmail());
        register.setPassword(signUp.getPassword());
        register.setFirstName(signUp.getFirstName());
        register.setLastName(signUp.getLastName());
        register.setPhoneNumber(signUp.getPhoneNumber());

        //If the registration was successful, it'll take the user to the welcome page
    model.addAttribute("title", signUp.getFirstName());
    model.addAttribute("user", register);
    return "welcome_user";
  
 }
}