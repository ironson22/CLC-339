package com.gcu.clc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sign up
@RequestMapping("/")
public class IndexController {
    @Autowired
    private HttpSession session;
    /** 
     * Displays the index file
     * @param model A model that is used as the display
     * @return The file to which will be viewed at this mapping
     */
    @GetMapping("/index/")
    public String display(Model model){
		model.addAttribute("title", "Index");
        //Checks if a user is logged in
        if(session.getAttribute("loggedIn") == null){
            session.setAttribute("loggedIn", false);
        }
        return "index";
    }
}