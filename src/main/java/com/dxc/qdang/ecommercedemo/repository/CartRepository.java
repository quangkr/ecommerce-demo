package com.dxc.qdang.ecommercedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.CartDetail;

public interface CartRepository extends CrudRepository<CartDetail, Long> {

    CartDetail findByUser(AppUser user);

}
