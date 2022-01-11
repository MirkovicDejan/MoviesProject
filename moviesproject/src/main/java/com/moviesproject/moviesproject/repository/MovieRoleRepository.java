package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.MovieRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRoleRepository extends JpaRepository<MovieRole,Integer> {


}
