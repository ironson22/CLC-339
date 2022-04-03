package com.gcu.clc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Sign up
public class LoginController {
    /** 
     * @param model The model being used
     * @return Returns the file to which the user will be taken to
     */
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("title", "Login Form");
        return "login";
    }
}