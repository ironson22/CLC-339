package com.gcu.clc.controller;


import javax.validation.Valid;
import com.gcu.clc.business.RegistrationBusinessService;
import com.gcu.clc.model.RegistrationModel;
import com.gcu.clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegisterController {
    @Autowired
    private RegistrationBusinessService register;

    /** 
     * The registration page for the application
     * @param model The model to be used
     * @return Returns the file that the user will be taken to
     */
    @GetMapping("/")
    public String showRegister(Model model){
        model.addAttribute("title", "Registration");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "register";
    }
    
    /** 
     * The post mapping when registering, sends the info to the database
     * @param signUp the RegisterationModel being used
     * @param bindResult Used to determine errors
     * @param model The model being used
     * @return Returns the file that the user will be taken to
     */
    @PostMapping("/register")
    public String register(@Valid RegistrationModel signUp, BindingResult bindResult, Model model) {
        //If there were errors, it'll take the user to the registration page again
        if(bindResult.hasErrors()){
            model.addAttribute("title", "Registration");
            return "register";
        }
        //When you register, it sets each property to the value of the corresponding value. Email and password are then used to set the temporary login info, used to login a user.
        UserModel user = register.createAccount(signUp);
        //Checks to see if a user was returned
        if(user != null){
            //Checks to see if the user id is -1, which is used to identify if a user with this email has already been made
            if(user.getUserId() == -1){
                model.addAttribute("error_message", "This email has already been used");
                return "register";
            }
            model.addAttribute("title", "Welcome");
            model.addAttribute("user", user);
            //Redirects back to the home page
            return "redirect:/";
        }else{
            //Returns back to the registration page if no user was returned
            model.addAttribute("error_message", "There was an issue creating your account. Please try again.");
            return "register";
        }
 }
}