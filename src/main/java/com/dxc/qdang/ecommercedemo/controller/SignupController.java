package com.dxc.qdang.ecommercedemo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dxc.qdang.ecommercedemo.dto.AppUserDto;
import com.dxc.qdang.ecommercedemo.exception.UserAlreadyExistsException;
import com.dxc.qdang.ecommercedemo.service.SignupService;

@Controller
public class SignupController {

    @Autowired
    SignupService signupService;

    @GetMapping("/signup")
    public String showSignupPage(@ModelAttribute("user") AppUserDto userDto) {
        return "signup";
    }

    @PostMapping("/signup")
    public String doSignup(
            HttpServletRequest request,
            @ModelAttribute("user") @Valid AppUserDto userDto,
            BindingResult bindingResult)
            throws ServletException {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            signupService.registerNewUser(userDto);
            request.login(userDto.getEmail(), userDto.getPassword());
        } catch (UserAlreadyExistsException e) {
            bindingResult.rejectValue("email", "EmailExists", "An account already exists with this email address");
            return "signup";
        }

        return "redirect:/";
    }

}
