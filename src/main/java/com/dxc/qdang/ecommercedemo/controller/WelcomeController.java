package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String showWelcomePage(Model model) {
        SecurityContext sc = SecurityContextHolder.getContext();
        String currentUserName = sc.getAuthentication().getName();
        model.addAttribute("currentUser", currentUserName);
        return "welcome";
    }

}
