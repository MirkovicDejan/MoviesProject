package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository2 extends JpaRepository<Content,Integer>{

    List<Content> findAllByOrderByReleaseDateAsc();

    List<Content> findAllByOrderByReleaseDateDesc();

}
