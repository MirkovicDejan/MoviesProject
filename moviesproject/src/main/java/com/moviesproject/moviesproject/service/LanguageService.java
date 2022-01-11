package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Language;
import com.moviesproject.moviesproject.repository.LanguageRepository;
import lombok.Data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class LanguageService {

    private final LanguageRepository languageRepository;

    public Language save(Language language) throws Exception {
           if (language.getCode().length <= 10) {
               return languageRepository.save(language);
           }
             throw new Exception("Your lenght is to long !");
    }

    public Language findOneLanguage(Integer id) {
        Optional<Language> language = languageRepository.findById(id);
        if(language.isPresent()){
            return language.get();
        }return null;
    }


    public List<Language> findAllLanguage() {
        return languageRepository.findAll();
    }

    public Language update(Integer id, String name, char[] code) throws Exception {
        Language find = findOneLanguage(id);
        find.setName(name);
        find.setCode(code);
        if(find.getCode().length <= 10) {
            return languageRepository.save(find);
        } throw new Exception("Your lenght is to long !");
    }

    public String delete(Integer id) {
        languageRepository.deleteById(id);
        return "Language with id: "+String.valueOf(id)+" is delete !";
    }
}
