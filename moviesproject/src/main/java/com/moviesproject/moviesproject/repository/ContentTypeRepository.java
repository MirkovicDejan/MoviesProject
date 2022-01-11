package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentTypeRepository extends JpaRepository<ContentType,Integer>{


}
