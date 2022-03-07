package com.dxc.qdang.ecommercedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.qdang.ecommercedemo.model.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    AppUser findByEmail(String email);

}
