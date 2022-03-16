package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.security.AppUserDetails;
import com.dxc.qdang.ecommercedemo.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(path = { "", "/" })
    public ModelAndView showCartPage(@AuthenticationPrincipal AppUserDetails userDetails) {
        return new ModelAndView("cart", "cart", cartService.getCart(userDetails));
    }

    @PostMapping("/{id}")
    public String addToCart(@PathVariable(name = "id") Long productId,
            @AuthenticationPrincipal AppUserDetails userDetails) {
        cartService.addToCart(userDetails, productId);

        return "redirect:/product/" + productId;
    }

}
