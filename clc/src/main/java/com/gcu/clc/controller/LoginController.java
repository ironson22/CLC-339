package com.gcu.clc.controller;


import javax.validation.Valid;

import com.gcu.clc.business.LoginBusinessService;
import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.ProductModel;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private LoginBusinessService loginBusinessService;
    

    /** 
     * @param model The model being used
     * @return Returns the file to which the user will be taken to
     */
    @GetMapping("/")
    public String showLogin(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
    /**
     * 
     * @param login The LoginModel being used
     * @param bindResult Used to determine if there were any errors 
     * @param model The model being used
     * @return returns the file to which the user will be taken to
     */
    @PostMapping("/doLogin")
    public String login(@Valid LoginModel login, BindingResult bindResult, Model model) {
        if (login.getEmail().equals(loginBusinessService.getEmail()) && login.getPassword().equals(loginBusinessService.getPassword())) {
            //If the input fields have errors, it will take the user to the login page again
            if (bindResult.hasErrors()) {
                model.addAttribute("title", "Login Form");

                return "login";
            }
            //If the login is successful, it'll change the title attribute to Welcome and take the user to the welcome_user file
            model.addAttribute("title", "Welcome");
            model.addAttribute("user", loginBusinessService);
            return "welcome_user";
        } else {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        
    }
}