package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {

Language findByName(String name);
}
