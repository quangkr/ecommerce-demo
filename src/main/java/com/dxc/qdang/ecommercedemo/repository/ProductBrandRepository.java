package com.dxc.qdang.ecommercedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.ProductBrand;

@Repository
public interface ProductBrandRepository extends CrudRepository<ProductBrand, Long> {

}
