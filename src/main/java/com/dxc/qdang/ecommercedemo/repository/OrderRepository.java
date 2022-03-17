package com.dxc.qdang.ecommercedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.OrderDetail;

public interface OrderRepository extends CrudRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByUser(AppUser user);

}
