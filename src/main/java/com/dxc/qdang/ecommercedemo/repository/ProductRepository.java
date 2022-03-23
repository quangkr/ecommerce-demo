package com.dxc.qdang.ecommercedemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.Product;
import com.dxc.qdang.ecommercedemo.model.ProductCategory;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findByCategory(ProductCategory category, Pageable pageable);

}
