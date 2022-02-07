package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Language findByName(String name);
    boolean existsByName(String name);
    boolean existsByCode(String code);
    Page<Language>findByName(String name, Pageable pageable);
    Page<Language>findByCode(String code, Pageable pageable);


}
