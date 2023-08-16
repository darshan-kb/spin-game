package com.spin.game.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/signin")
    public String customLogin(Model model){
        model.addAttribute("title","login");
        return "login.html";
    }

    @GetMapping("/demo")
    public String demo(Authentication a){
        return "Welcome "+a.getName();
    }

    @GetMapping("/check/admin")
    public String checkAdmin(Authentication a){
        return "working!";
    }
}
