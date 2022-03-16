package com.dxc.qdang.ecommercedemo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.repository.ProductRepository;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @RequestMapping("/")
    public ModelAndView showHomePage(Model model) {
        List<Product> products = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return new ModelAndView("index", "products", products);
    }

    @RequestMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("activeProfile", activeProfile);
        return "about";
    }

}
