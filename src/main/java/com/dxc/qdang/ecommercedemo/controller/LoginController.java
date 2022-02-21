package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.qdang.ecommercedemo.service.LoginService;

@Controller
//@SessionAttributes()
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String showWelcomePage(@RequestParam String username, @RequestParam String password) {
        boolean isUserValid = loginService.validateUser(username, password);

        if (isUserValid)
            return "welcome";
        else {
            return "login";
        }
    }
}
