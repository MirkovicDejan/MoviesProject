package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.MoviePeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePeopleRepository extends JpaRepository<MoviePeople,Integer>{

}
