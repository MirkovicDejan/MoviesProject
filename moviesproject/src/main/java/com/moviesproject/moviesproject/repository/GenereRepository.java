package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepository extends JpaRepository<Genere,Integer>{

 Genere findByName(String name);


}
