package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOLanguage;
import com.moviesproject.moviesproject.exception.ApiRequestException;
import com.moviesproject.moviesproject.model.Language;
import com.moviesproject.moviesproject.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @PostMapping("/create-new-language")
    public DTOLanguage createLanguage(@RequestBody DTOLanguage dtoLanguage) {
        return languageService.createNewLanguage(dtoLanguage);
    }
    @GetMapping("/all-language-page")
    public Page<Language> allLanguageWithPage(Pageable pageable){
        return languageService.allLanguageWithPage(pageable);
    }

    @GetMapping("/get-by-name-pageable")
    public Page<Language>getByNamePage(@RequestParam String name,Pageable pageable){
        return languageService.getByLanguagePage(name,pageable);
    }

    @GetMapping("/get-by-code-pageable")
    public  Page<Language>getByCodePage(@RequestParam String code,Pageable pageable){
        return languageService.getByCodePage(code,pageable);
    }

    @GetMapping("/get-all-page-size")
    public Page<Language>request(@RequestParam Integer page, @RequestParam Integer size){
      return languageService.languagePagination(page,size);
    }

    @DeleteMapping("/delete-language")
    public void delete(Integer id) {
        languageService.delete(id);
    }
    }
