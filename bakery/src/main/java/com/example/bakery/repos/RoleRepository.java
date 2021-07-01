package com.example.bakery.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.bakery.domain.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {

}
