package com.gcu.clc.controller;


import com.gcu.clc.model.RegisterModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sign up
public class RegisterController {
    @GetMapping("/register")
    public String showLogin(){
        return "register";
    }
    //Check for Credentials
    @PostMapping("/register")
    public String register(@ModelAttribute(name="registerForm") RegisterModel signUp, Model m) {
    String usr = signUp.getUsername();
    String pas = signUp.getPassword();

    
    if(usr != null && pas != null) {
        signUp.addCred();
    }
    m.addAttribute("registered", "You have been registered");
    return "register";
  
 }
}