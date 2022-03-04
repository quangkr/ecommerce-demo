package com.dxc.qdang.ecommercedemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dxc.qdang.ecommercedemo.exception.UserAlreadyExistsException;
import com.dxc.qdang.ecommercedemo.model.AppUserDto;
import com.dxc.qdang.ecommercedemo.service.SignupService;

@Controller
public class SignupController {

    @Autowired
    SignupService signupService;

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        AppUserDto userDto = new AppUserDto();
        model.addAttribute("user", userDto);
        return "signup";
    }

    @PostMapping("/signup")
    public String doSignup(
            @ModelAttribute("user") @Valid AppUserDto userDto,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            signupService
                    .registerNewUser(userDto);
        } catch (UserAlreadyExistsException e) {
            bindingResult.rejectValue("email", "userDto.email",
                    "An account already exists with this email address");
            return "signup";
        }

        return "redirect:/";
    }

}
