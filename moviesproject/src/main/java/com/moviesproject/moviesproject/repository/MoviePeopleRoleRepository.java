package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.MoviePeopleRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePeopleRoleRepository extends JpaRepository<MoviePeopleRole,Integer>{



}
