package com.gcu.clc.controller;


import javax.validation.Valid;

import com.gcu.clc.model.RegistrationModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sign up
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/")
    public String display(Model model){
		model.addAttribute("title", "Registration");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "register";
    }
    @PostMapping("/doRegister")
    public String doRegister(@Valid RegistrationModel registrationModel, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Registration");
            return "register";
        }
        model.addAttribute("title", "Home");
        return "index";
    }
}