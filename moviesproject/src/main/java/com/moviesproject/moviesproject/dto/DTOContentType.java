package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.ContentType;
import lombok.Data;

@Data
public class DTOContentType {

    private String name;

    public ContentType createContentType(){

        ContentType ct = new ContentType();
        ct.setName(name);

        return ct;
    }

}
