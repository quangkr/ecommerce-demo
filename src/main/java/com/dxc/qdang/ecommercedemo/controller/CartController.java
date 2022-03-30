package com.dxc.qdang.ecommercedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.dto.CartItemDto;
import com.dxc.qdang.ecommercedemo.model.CartDetail;
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

    @PostMapping(path = { "", "/" })
    @ResponseBody
    public CartDetail addProduct(@AuthenticationPrincipal AppUserDetails userDetails,
            @RequestBody CartItemDto cartItemDto) {
        return cartService.addProduct(userDetails, cartItemDto.getProductId(), cartItemDto.getQuantity());
    }

    @PutMapping(path = { "", "/" })
    @ResponseBody
    public CartDetail setProductQuantity(@AuthenticationPrincipal AppUserDetails userDetails,
            @RequestBody CartItemDto cartItemDto) {
        return cartService.setProductQuantity(userDetails, cartItemDto.getProductId(), cartItemDto.getQuantity());
    }

    @DeleteMapping(path = { "", "/" })
    @ResponseBody
    public CartDetail removeProducts(@AuthenticationPrincipal AppUserDetails userDetails,
            @RequestBody List<Long> productIds) {
        return cartService.removeProducts(userDetails, productIds);
    }

}
