package com.dxc.qdang.ecommercedemo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dxc.qdang.ecommercedemo.model.AppUser;
import com.dxc.qdang.ecommercedemo.model.OrderDetail;

public interface OrderRepository extends PagingAndSortingRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByUser(AppUser user);
    List<OrderDetail> findAllByUser(Sort sort, AppUser user);
    Page<OrderDetail> findAllByUser(Pageable pageable, AppUser user);

}
