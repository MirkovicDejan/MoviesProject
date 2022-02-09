package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.repository.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    boolean existsByName(String name);
}
