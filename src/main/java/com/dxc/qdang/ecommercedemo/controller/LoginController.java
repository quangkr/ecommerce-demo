package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@SessionAttributes()
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}
