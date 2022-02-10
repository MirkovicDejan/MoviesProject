package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
     User findByUserName(String userName);
     boolean existsByUserName(String userName);
     boolean existsByEmail(String email);
     boolean existsByPassword(String password);
     boolean existsByPhoneNumber(String phoneNumber);
}
