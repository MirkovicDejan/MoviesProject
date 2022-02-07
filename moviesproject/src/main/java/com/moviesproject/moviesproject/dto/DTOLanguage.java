package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Language;
import lombok.Data;

@Data
public class DTOLanguage {
    private String name;
    private String code;

    public static DTOLanguage entityLanguageToDTO(Language language){
        DTOLanguage dto = new DTOLanguage();
        dto.setName(language.getName());
        dto.setCode(language.getCode());
        return dto;
    }

    public static Language DTOLanguageToEntity(DTOLanguage dtoLanguage){
        Language language = new Language();
        language.setName(dtoLanguage.getName());
        language.setCode(dtoLanguage.getCode());
        return language;
    }

}
