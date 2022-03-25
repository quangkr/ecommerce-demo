package com.dxc.qdang.ecommercedemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.service.ProductService;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("price").descending());
        Page<Product> cellphones = productService.getProductsByCategory(Optional.of("cellphone"), pageable);
        Page<Product> laptops = productService.getProductsByCategory(Optional.of("laptop"), pageable);

        model.addAttribute("cellphones", cellphones.getContent());
        model.addAttribute("laptops", laptops.getContent());

        return "index";
    }

}
