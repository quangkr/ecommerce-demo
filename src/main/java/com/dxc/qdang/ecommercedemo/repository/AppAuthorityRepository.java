package com.dxc.qdang.ecommercedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.AppAuthority;

@Repository
public interface AppAuthorityRepository
        extends JpaRepository<AppAuthority, Long> {

    AppAuthority findByName(String name);
    List<AppAuthority> findAllByName(String name);

}
