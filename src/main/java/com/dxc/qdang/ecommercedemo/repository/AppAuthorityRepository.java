package com.dxc.qdang.ecommercedemo.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.AppAuthority;

@Repository
public interface AppAuthorityRepository
        extends CrudRepository<AppAuthority, Long> {

    AppAuthority findByName(String name);

    Set<AppAuthority> findDistinctByNameIgnoreCaseIn(String... name);

    @Override
    Set<AppAuthority> findAll();

}
