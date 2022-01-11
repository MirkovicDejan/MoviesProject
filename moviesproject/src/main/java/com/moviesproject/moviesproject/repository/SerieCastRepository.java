package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.SerieCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieCastRepository extends JpaRepository<SerieCast,Integer>{


}
