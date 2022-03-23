package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/show")
    public ModelAndView showProductPage(@RequestParam("id") Long productId) {
        return new ModelAndView("product", "product", productService.getProductById(productId));
    }

}
