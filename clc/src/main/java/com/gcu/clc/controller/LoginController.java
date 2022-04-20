package com.gcu.clc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Sign up
public class LoginController {
    /** 
     * The login page that the user goes to. SecurityConfig handles the login functionality
     * @param model The model being used
     * @return Returns the file to which the user will be taken to
     */
    @GetMapping("/login")
    public String showLogin(Model model, HttpSession session) {
        model.addAttribute("title", "Login Form");
        return "login";
    }
}