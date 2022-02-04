package com.gcu.clc.controller;


import javax.validation.Valid;

import com.gcu.clc.model.RegistrationModel;

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
    @GetMapping("/")
    public String showLogin(Model model){
        model.addAttribute("title", "Registration");
        model.addAttribute("registerModel", new RegistrationModel());
        return "register";
    }
    //Check for Credentials
    @PostMapping("/doRegister")
    public String register(@Valid RegistrationModel signUp, BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()){
            model.addAttribute("title", "Registration");
            return "register";
        }
    // String usr = signUp.getUsername();
    // String pas = signUp.getPassword();

    
    // if(usr != null && pas != null) {
    //     RegisterModel.savedPassword.add(usr);
    //     RegisterModel.savedPassword.add(pas);
    // }
    model.addAttribute("title", "Welcome");
    return "welcome_user";
  
 }
}