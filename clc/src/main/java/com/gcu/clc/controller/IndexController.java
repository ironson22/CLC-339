package com.gcu.clc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Sign up
@RequestMapping("/")
public class IndexController {
    
    /** 
     * Displays the index file
     * @param model A model that is used as the display
     * @return The file to which will be viewed at this mapping
     */
    @GetMapping("/index/")
    public String display(Model model){
		model.addAttribute("title", "Index");
        return "index";
    }
}