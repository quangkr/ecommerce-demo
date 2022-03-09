package com.dxc.qdang.ecommercedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.AppAuthority;

@Repository
public interface AppAuthorityRepository
        extends CrudRepository<AppAuthority, Long> {

    AppAuthority findByName(String name);

    AppAuthority findByNameIgnoreCase(String name);

}
