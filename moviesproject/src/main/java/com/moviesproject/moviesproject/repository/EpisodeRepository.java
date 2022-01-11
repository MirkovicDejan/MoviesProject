package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {

}
