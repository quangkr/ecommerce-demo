package com.dxc.qdang.ecommercedemo.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.qdang.ecommercedemo.dto.AdminProductDto;
import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.model.ProductBrand;
import com.dxc.qdang.ecommercedemo.model.ProductCategory;
import com.dxc.qdang.ecommercedemo.repository.ProductBrandRepository;
import com.dxc.qdang.ecommercedemo.repository.ProductCategoryRepository;
import com.dxc.qdang.ecommercedemo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductBrandRepository productBrandRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Iterable<ProductBrand> getAllProductBrands() { return productBrandRepository.findAll(); }

    public Iterable<ProductCategory> getAllProductCategories() { return productCategoryRepository.findAll(); }

    public Page<Product> getProductsByCategory(String categoryName, Pageable pageable) {
        Optional<ProductCategory> category = productCategoryRepository.findByNameIgnoreCase(categoryName);
        if (category.isPresent()) {
            return productRepository.findByCategory(category.get(), pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }

    public Product addProduct(AdminProductDto productDto) throws IllegalArgumentException {
        Product product = convertDtoToEntity(productDto);
        return productRepository.save(product);
    }

    public Product updateProduct(long productId, AdminProductDto productDto) throws IllegalArgumentException {
        Product product = convertDtoToEntity(productDto);
        product.setId(productId);
        return productRepository.save(product);
    }

    private Product convertDtoToEntity(AdminProductDto productDto) throws IllegalArgumentException {
        Optional<ProductBrand> brand = productBrandRepository.findByNameIgnoreCase(productDto.getBrand());
        Optional<ProductCategory> category = productCategoryRepository.findByNameIgnoreCase(productDto.getCategory());
        if (!brand.isPresent() || !category.isPresent()) {
            throw new IllegalArgumentException();
        } else {
            return new Product(
                    productDto.getName(),
                    Arrays.stream(productDto.getDescription()).filter(d -> !"".equals(d.trim())).toArray(String[]::new),
                    productDto.getThumbnailUrl(),
                    Integer.parseInt(productDto.getPrice()),
                    brand.get(),
                    category.get());
        }
    }

}
