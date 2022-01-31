package com.moviesproject.moviesproject.repository;


import com.moviesproject.moviesproject.model.ContentGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentGenreRepository extends JpaRepository<ContentGenre,Integer>{



}
