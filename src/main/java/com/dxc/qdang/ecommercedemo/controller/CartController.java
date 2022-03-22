package com.dxc.qdang.ecommercedemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.dto.CartItemDto;
import com.dxc.qdang.ecommercedemo.dto.ShippingDetailDto;
import com.dxc.qdang.ecommercedemo.model.CartDetail;
import com.dxc.qdang.ecommercedemo.security.AppUserDetails;
import com.dxc.qdang.ecommercedemo.service.CartService;
import com.dxc.qdang.ecommercedemo.service.OrderService;

@Controller
@RequestMapping("/cart")
@SessionAttributes(names = { "shippingDetail" })
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

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

    @GetMapping("/checkout")
    public ModelAndView showCheckoutPage(@AuthenticationPrincipal AppUserDetails userDetails,
            @ModelAttribute(name = "shippingDetail") ShippingDetailDto shippingDetail) {
        return new ModelAndView("checkout", "cart", cartService.getCart(userDetails));
    }

    @PostMapping("/checkout")
    public ModelAndView confirmCheckout(@AuthenticationPrincipal AppUserDetails userDetails,
            @ModelAttribute(name = "shippingDetail") @Valid ShippingDetailDto shippingDetail,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("checkout", "cart", cartService.getCart(userDetails));
        }

        return new ModelAndView("checkoutConfirm", "cart", cartService.getCart(userDetails));
    }

    @PostMapping("/checkoutConfirm")
    public String proceedCheckout(@AuthenticationPrincipal AppUserDetails userDetails,
            @ModelAttribute(name = "shippingDetail") @Valid ShippingDetailDto shippingDetail,
            SessionStatus sessionStatus) {
        orderService.addOrder(userDetails, shippingDetail);
        sessionStatus.setComplete();

        return "checkoutSuccess";
    }

    @ModelAttribute(name = "shippingDetail")
    private ShippingDetailDto shippingDetailDto() {
        return new ShippingDetailDto();
    }

}
