package com.dxc.qdang.ecommercedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/show")
    public ModelAndView showProductPage(@RequestParam("id") Long productId) {
        return new ModelAndView("product", "product", productService.getProductById(productId));
    }

    @GetMapping("/product")
    public String showProductsByCategory(
            Model model,
            @RequestParam("category") String categoryName,
            @PageableDefault(size = 10, sort = "price", direction = Direction.DESC) Pageable pageable) {
        Page<Product> productPage = productService.getProductsByCategory(categoryName, pageable);

        model.addAttribute("categoryName", categoryName);
        model.addAttribute("displayedCategoryName",
                categoryName.substring(0, 1).toUpperCase() + categoryName.substring(1).toLowerCase());
        model.addAttribute("productPage", productPage);

        return "productlist";
    }

}
