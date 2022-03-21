package com.dxc.qdang.ecommercedemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.dto.ShippingDetailDto;
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

    @ModelAttribute(name = "shippingDetail")
    private ShippingDetailDto shippingDetailDto() {
        return new ShippingDetailDto();
    }

}
