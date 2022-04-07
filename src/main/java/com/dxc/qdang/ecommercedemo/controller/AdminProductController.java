package com.dxc.qdang.ecommercedemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.qdang.ecommercedemo.dto.AdminProductDto;
import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ModelAndView showProductsPage(
            @PageableDefault(
                    size = 10,
                    sort = { "category", "brand", "price" },
                    direction = Direction.DESC) Pageable pageable) {
        return new ModelAndView("admin-product", "products", productService.getAllProducts(pageable));
    }

    @GetMapping("/product/new")
    public String showProductAddPage(Model model) {
        model.addAttribute("title", "New product");
        model.addAttribute("product", new AdminProductDto());
        model.addAttribute("productId", "new");

        return "admin-product-editor";
    }

    @GetMapping("/product/{id}")
    public String showProductEditPage(@PathVariable("id") long productId, Model model) {
        Product product = productService.getProductById(productId);
        AdminProductDto productDto = new AdminProductDto(
                product.getName(),
                product.getDescription(),
                product.getThumbnailUrl(),
                Integer.toString(product.getPrice()),
                product.getBrand().getName(),
                product.getCategory().getName());
        model.addAttribute("title", product.getName());
        model.addAttribute("product", productDto);
        model.addAttribute("productId", Long.toString(productId));

        return "admin-product-editor";
    }

    @PostMapping("/product/new")
    public String addProduct(Model model,
            @ModelAttribute("product") @Valid AdminProductDto productDto,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                productService.addProduct(productDto);
            } catch (IllegalArgumentException e) {
                bindingResult.rejectValue("brand", "InvalidBrand", "Invalid value");
                bindingResult.rejectValue("category", "InvalidCategory", "Invalid value");
            }
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "New product");
            model.addAttribute("productId", "new");
            return "admin-product-editor";
        }

        return "redirect:/admin/products";
    }

    @PostMapping("/product/{id}")
    public String updateProduct(@PathVariable("id") long productId,
            Model model,
            @ModelAttribute("product") @Valid AdminProductDto productDto,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                productService.updateProduct(productId, productDto);
            } catch (IllegalArgumentException e) {
                bindingResult.rejectValue("brand", "InvalidBrand", "Invalid value");
                bindingResult.rejectValue("category", "InvalidCategory", "Invalid value");
            }
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", productDto.getName());
            model.addAttribute("productId", Long.toString(productId));
            return "admin-product-editor";
        }

        return "redirect:/admin/products";
    }

}
