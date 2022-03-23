package com.dxc.qdang.ecommercedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.repository.ProductCategoryRepository;
import com.dxc.qdang.ecommercedemo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Page<Product> getProductsByCategory(String categoryName, Pageable pageable) {
        return productRepository.findByCategory(productCategoryRepository.findByName(categoryName), pageable);
    }

}
