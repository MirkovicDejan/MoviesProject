package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
     boolean existsByUserName(String userName);
     boolean existsByEmail(String email);
     boolean existsByPassword(String password);
     boolean existsByPhoneNumber(String phoneNumber);
}
