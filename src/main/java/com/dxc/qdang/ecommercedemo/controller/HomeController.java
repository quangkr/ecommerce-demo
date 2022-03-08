package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        return "index";
    }

    @RequestMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("activeProfile", activeProfile);
        return "about";
    }

}
