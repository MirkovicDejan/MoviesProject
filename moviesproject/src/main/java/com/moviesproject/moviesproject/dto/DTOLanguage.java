package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Language;
import lombok.Data;

@Data
public class DTOLanguage {

    private String name;
    private char [] code;

    public Language createLanguage(){

        Language language = new Language();
        language.setName(name);
        language.setCode(code);

        return language;

    }
}
