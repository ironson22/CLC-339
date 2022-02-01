package com.gcu.clc.controller;


import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.RegisterModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sign up

public class LoginController {
    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }
    //Check for Credentials
    @PostMapping("/login")
    public String login(@ModelAttribute(name="loginForm") LoginModel login, Model m) {
    String uname = login.getUsername();
    String pass = login.getPassword();

    boolean containsUser = RegisterModel.SavedUsers.contains(uname);
    boolean containsPassword = RegisterModel.SavedPassword.contains(pass);
    
    if(containsUser && containsPassword) {
        m.addAttribute("uname", uname);
        m.addAttribute("pass", pass);
        return "welcome_User";
    }
    m.addAttribute("error", "Incorrect Username or Password");
    return "login";
  
 }
}