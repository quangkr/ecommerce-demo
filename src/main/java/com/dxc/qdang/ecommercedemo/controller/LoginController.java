package com.dxc.qdang.ecommercedemo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping(path = "/login", params = "error")
    public String showLoginError(Model model,
            @RequestParam(name = "username", required = false) Optional<String> username,
            @RequestParam(name = "remember-me", required = false) Optional<String> rememberMe) {
        model.addAttribute("username", username.orElse(""));
        model.addAttribute("rememberMe", rememberMe.isPresent());
        return "login";
    }

}
