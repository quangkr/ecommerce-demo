package com.dxc.qdang.ecommercedemo.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dxc.qdang.ecommercedemo.model.CartDetail;
import com.dxc.qdang.ecommercedemo.security.AppUserDetails;
import com.dxc.qdang.ecommercedemo.service.CartService;

@ControllerAdvice
public class CartControllerAdvice {

    @Autowired
    CartService cartService;

    @ModelAttribute("cart")
    public CartDetail setCartDetail(@AuthenticationPrincipal AppUserDetails userDetails) {
        if (userDetails == null) {
            return null;
        }
        return cartService.getCart(userDetails);
    }

}
