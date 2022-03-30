package com.dxc.qdang.ecommercedemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.dxc.qdang.ecommercedemo.dto.ShippingDetailDto;
import com.dxc.qdang.ecommercedemo.security.AppUserDetails;
import com.dxc.qdang.ecommercedemo.service.CartService;
import com.dxc.qdang.ecommercedemo.service.OrderService;

@Controller
@RequestMapping("/checkout")
@SessionAttributes(names = { "shippingDetail" })
public class CheckoutController {

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @GetMapping({ "", "/" })
    public String showCheckoutPage(@ModelAttribute(name = "shippingDetail") ShippingDetailDto shippingDetail) {
        return "checkout";
    }

    @PostMapping({ "", "/" })
    public String confirmCheckout(@ModelAttribute(name = "shippingDetail") @Valid ShippingDetailDto shippingDetail,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "checkout";
        }

        return "checkoutConfirm";
    }

    @PostMapping("/confirm")
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
