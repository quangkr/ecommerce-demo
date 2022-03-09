package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.service.ProductService;

@Controller
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/product")
    public String showProductPage(@RequestParam Long productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "product";
    }

}
