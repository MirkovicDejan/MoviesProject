package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.MovieCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCastRepository extends JpaRepository<MovieCast,Integer>{


}
