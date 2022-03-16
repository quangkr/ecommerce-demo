package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String updateProductQuantity(@AuthenticationPrincipal AppUserDetails userDetails,
            @RequestHeader(name = HttpHeaders.REFERER) String referer,
            @PathVariable(name = "id") long productId,
            @RequestParam(name = "action", required = true) String action,
            @RequestParam(name = "quantity", defaultValue = "1") int quantity) {

        if (action.equalsIgnoreCase("add")) {
            cartService.addProductToCart(userDetails, productId, quantity);
        } else if (action.equalsIgnoreCase("update")) {
            cartService.updateProductQuantity(userDetails, productId, quantity);
        }

        return "redirect:" + referer;
    }

}
