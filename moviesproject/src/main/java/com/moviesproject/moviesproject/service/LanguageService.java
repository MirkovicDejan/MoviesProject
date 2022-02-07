package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.dto.DTOLanguage;
import com.moviesproject.moviesproject.exception.ApiRequestException;
import com.moviesproject.moviesproject.model.Language;
import com.moviesproject.moviesproject.repository.LanguageRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class LanguageService {
    private final LanguageRepository languageRepository;

    public DTOLanguage createNewLanguage(DTOLanguage dtoLanguage) {
        Language convertForSave = DTOLanguage.DTOLanguageToEntity(dtoLanguage);
        if (languageRepository.existsByName(convertForSave.getName())) {
            throw new ApiRequestException("Language with : " + convertForSave.getName() + " exists in database !");
        } else if (languageRepository.existsByCode(convertForSave.getCode())) {
            throw new ApiRequestException("Code is in use for some Language ! Please insert another !");
        } else if (convertForSave.getName().length() > 100) {
            throw new ApiRequestException("Name for Language is to long ! Must be less then 100 characters !");
        } else if (convertForSave.getCode().length() > 10) {
            throw new ApiRequestException("Code : " + convertForSave.getCode().toString() + " for Language is to Long ! Must be less then 10 characters !");
        } else {
            return DTOLanguage.entityLanguageToDTO(languageRepository.save(convertForSave));
        }
    }

    public DTOLanguage update(Integer id, DTOLanguage dtoLanguage) {
        Language convertForUpdate = DTOLanguage.DTOLanguageToEntity(dtoLanguage);
        if(!languageRepository.existsById(id)){
            throw new ApiRequestException("Language with id : "+id+" don't exists in database !");
        }else if(languageRepository.existsByName(convertForUpdate.getName())){
            throw new ApiRequestException("Name : "+ convertForUpdate.getName()+" is in use for some Language !");
        }else if (languageRepository.existsByCode(convertForUpdate.getCode())) {
            throw new ApiRequestException("Code : "+convertForUpdate.getCode()+"is in use for some Language ! Please insert another !");
        } else if (convertForUpdate.getName().length() > 100) {
            throw new ApiRequestException("Name for Language is to long ! Must be less then 100 characters !");
        } else if (convertForUpdate.getCode().length() > 10) {
            throw new ApiRequestException("Code : " + convertForUpdate.getCode().toString() + " for Language is to Long ! Must be less then 10 characters !");
        } else {
            convertForUpdate.setLanguageId(id);
            return DTOLanguage.entityLanguageToDTO(languageRepository.save(convertForUpdate));
        }
    }

    public Page<Language> allLanguageWithPage(Pageable pageable) {
        Page<Language> list = languageRepository.findAll(pageable);
        if (list.isEmpty()) {
            throw new ApiRequestException("Database is empty !");
        } else {
            return list;
        }
    }

    public void delete(Integer id) {
        if (languageRepository.existsById(id)) {
            languageRepository.deleteById(id);
        } else {
            throw new ApiRequestException("Language can't be deleted ! Because Language with id:" + id + " don't exists in database !");
        }
    }

    public Page<Language> getByLanguagePage(String name, Pageable pageable) {
        if (languageRepository.existsByName(name)) {
            return languageRepository.findByName(name, pageable);
        } else {
            throw new ApiRequestException("Language with name : " + name + " don't exists in database !");
        }
    }

    public Page<Language> getByCodePage(String code, Pageable pageable) {
        if (languageRepository.existsByCode(code)) {
            return languageRepository.findByCode(code, pageable);
        } else {
            throw new ApiRequestException("Language with code : " + code + " don't exists in database !");
        }
    }

    public Page<Language> languagePagination(Integer page, Integer size) {
        Page<Language> language = languageRepository.findAll(PageRequest.of(page,size));
        if (language.isEmpty()){
            throw new ApiRequestException("Database is empty !");
        }else {
            return language;
        }
    }

    public Page<Language> allAsc(Integer page, Integer size, String nameORcode) {
        Page<Language> languageAsc = languageRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Direction.ASC,nameORcode)));
        if (languageAsc.isEmpty()){
            throw new ApiRequestException("Database is empty !");
        }else{
            return languageAsc;
        }
    }

    public Page<Language> allDESC(Integer page, Integer size, String nameORcode) {
        Page<Language> languageDESC = languageRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Direction.DESC,nameORcode)));
        if(languageDESC.isEmpty()){
            throw new ApiRequestException("Database is empty !");
        }else {
            return languageDESC;
        }
    }

    public Page<Language> allAscID(Integer page, Integer size, Integer id) {
        Page<Language> languageASC = languageRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Direction.ASC, String.valueOf(id))));
        if(languageASC.isEmpty()){
            throw new ApiRequestException("Database is empty !");
        }else {
            return languageASC;
        }
    }

    public Page<Language> allDescID(Integer page, Integer size, Integer id) {
        Page<Language> languageDESC = languageRepository.findAll(PageRequest.of(page,size,Sort.by(Sort.Direction.DESC, String.valueOf(id))));
        if(languageDESC.isEmpty()){
            throw new ApiRequestException("Database is empty !");
        }else {
            return languageDESC;
        }
    }
}

