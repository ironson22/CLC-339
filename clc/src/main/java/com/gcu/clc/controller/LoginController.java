package com.gcu.clc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sign up
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/")
    public String display(Model model){
		model.addAttribute("title", "Login");
        return "login";
    }
}