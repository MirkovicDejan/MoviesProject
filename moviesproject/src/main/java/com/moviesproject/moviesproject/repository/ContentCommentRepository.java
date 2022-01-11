package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContentCommentRepository extends JpaRepository<ContentComment,Integer>{



}
