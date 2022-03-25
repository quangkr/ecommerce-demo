package com.dxc.qdang.ecommercedemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public ModelAndView showProductPage(@PathVariable("id") Long productId) {
        return new ModelAndView("product", "product", productService.getProductById(productId));
    }

    @GetMapping("/products/{category}")
    public String showProductsByCategory(
            Model model,
            @PathVariable(name = "category", required = false) Optional<String> categoryName,
            @PageableDefault(size = 10, sort = { "category", "price" }, direction = Direction.DESC) Pageable pageable) {
        Page<Product> productPage = productService.getProductsByCategory(categoryName, pageable);

        if (categoryName.isPresent()) {
            model.addAttribute("categoryName", categoryName.get());
            model.addAttribute("title",
                    categoryName.get().substring(0, 1).toUpperCase() + categoryName.get().substring(1).toLowerCase());
        } else {
            model.addAttribute("title", "Products");
        }
        model.addAttribute("productPage", productPage);

        return "productlist";
    }

}
