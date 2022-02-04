package com.gcu.clc.controller;


import javax.validation.Valid;

import com.gcu.clc.model.LoginModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
//Sign up
public class LoginController {
    @GetMapping("/")
    public String showLogin(Model model){
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel("", ""));
        return "login";
    }
    //Check for Credentials
    @PostMapping("/doLogin")
    public String login(@Valid LoginModel login, BindingResult bindResult, Model model) {
        if(bindResult.hasErrors()){
            model.addAttribute("title", "Login Form");

            return "login";
        }
            // String email = login.getEmail();
            // String password = login.getPassword();

    // boolean containsUser = RegisterModel.savedUsers.contains(uname);
    // boolean containsPassword = RegisterModel.savedPassword.contains(pass);
    
    // if(containsUser && containsPassword) {
    //     m.addAttribute("uname", uname);
    //     m.addAttribute("pass", pass);
    //     return "welcome_User";
    // }
    // m.addAttribute("error", "Incorrect Username or Password");
    model.addAttribute("title", "Welcome");
    return "welcome_user";
 }
}