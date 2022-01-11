package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOLanguage;
import com.moviesproject.moviesproject.model.Language;
import com.moviesproject.moviesproject.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping("/createLanguage")
    public Language createLanguage(@RequestBody DTOLanguage dtoLanguage) throws Exception {
           return languageService.save(dtoLanguage.createLanguage());
    }

    @GetMapping("/findOneLanguage")
    public Language findLanguage(@RequestParam Integer id){
        return languageService.findOneLanguage(id);
    }

    @GetMapping("/findAllLanguage")
    public List<Language> allLanguage(){
        return languageService.findAllLanguage();
    }

    @PutMapping("/updateLanguage")
    public Language updateLanguage(@RequestParam Integer id, @RequestParam String name,@RequestParam char code []) throws Exception {
        return languageService.update(id,name,code);
    }

    @DeleteMapping("/deleteLanguage")
    public String deleteLanguage(@RequestParam Integer id){
        languageService.delete(id);
        return "Language with id: "+String.valueOf(id)+" is delete !";
    }



}
