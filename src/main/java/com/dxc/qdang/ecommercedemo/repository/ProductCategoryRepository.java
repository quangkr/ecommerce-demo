package com.dxc.qdang.ecommercedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

    ProductCategory findByName(String name);

}
