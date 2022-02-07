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

    @PutMapping("/update-language")
    public DTOLanguage updateLanguage(@RequestParam Integer id, @RequestBody DTOLanguage dtoLanguage){
        return languageService.update(id,dtoLanguage);
    }

    @GetMapping("/all-language-pageable")
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

    @GetMapping("/get-all-pageable-size")
    public Page<Language>request(@RequestParam Integer page, @RequestParam Integer size){
      return languageService.languagePagination(page,size);
    }

    @GetMapping("/get-all-pageable-asc-name-or-code")
    public  Page<Language>findAllASCPageableField(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String nameORcode){
        return  languageService.allAsc(page,size,nameORcode);
    }

    @GetMapping("/get-all-pageable-desc-name-or-code")
    public  Page<Language>findAllDECSPageableField(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String nameORcode){
        return  languageService.allDESC(page,size,nameORcode);
    }

    @GetMapping("/get-all-pageable-asc-id")
    public  Page<Language>findAllASCPageableField(@RequestParam Integer page, @RequestParam Integer size, @RequestParam Integer id){
        return  languageService.allAscID(page,size,id);
    }
    @GetMapping("/get-all-pageable-desc-id")
    public  Page<Language>findAllDESCPageableField(@RequestParam Integer page, @RequestParam Integer size, @RequestParam Integer id){
        return  languageService.allDescID(page,size,id);
    }

    @DeleteMapping("/delete-language")
    public void delete(Integer id) {
        languageService.delete(id);
    }
    }
