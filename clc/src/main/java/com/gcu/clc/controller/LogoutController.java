package com.gcu.clc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logout")
public class LogoutController {
    @Autowired
    private HttpSession session;
    /**
     * Very simple logout functionality. SecurityConfig handles signing out the user, the controller invalidates the session.
     */
    @GetMapping("/")
    public void logout(){
        session.invalidate();
    }
}
