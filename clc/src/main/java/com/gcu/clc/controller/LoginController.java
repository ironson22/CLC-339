package com.gcu.clc.controller;


import javax.validation.Valid;
import com.gcu.clc.business.LoginBusinessService;
import com.gcu.clc.model.LoginModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(path="/", method={RequestMethod.GET})
    public String showLogin(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("error_message", "");
        return "login";
    }
    /**
     * 
     * @param login The LoginModel being used
     * @param bindResult Used to determine if there were any errors 
     * @param model The model being used
     * @return returns the file to which the user will be taken to
     */
    @RequestMapping(path="/doLogin", method={RequestMethod.GET, RequestMethod.POST})
    public String login(@Valid LoginModel login, BindingResult bindResult, Model model) {
        //If there were errors, it'll take the user to the login page again
        if (bindResult.hasErrors()) {
                    model.addAttribute("title", "Login Form");
                    return "login";
        }
        UserModel user = loginBusinessService.authenticateAccount(login);
        if (user != null){
            if(user.getUserId() == -1){
                model.addAttribute("error_message", "Email or Password is incorrect");
                return "login";
            }
            //need to add error handling
            //If the login is successful, it'll change the title attribute to Welcome and take the user to the welcome_user file
            model.addAttribute("title", "Welcome");
            model.addAttribute("user", user);
            return "welcome_user";
        } else {
            model.addAttribute("error_message", "There was an issue getting your account. Please try again.");
            return "login";
        }
        
    }
}