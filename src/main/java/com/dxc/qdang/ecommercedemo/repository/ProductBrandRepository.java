package com.dxc.qdang.ecommercedemo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.ProductBrand;

@Repository
public interface ProductBrandRepository extends CrudRepository<ProductBrand, Long> {

    Optional<ProductBrand> findByNameIgnoreCase(String name);

}
