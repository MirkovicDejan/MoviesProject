package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer>{
    boolean existsByUser(User user);
    UserRole findByUser(User user);

}
