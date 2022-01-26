package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Genre;
import lombok.Data;

@Data
public class DTOGenere {

    private String name;

    public Genre createGenere(){

        Genre g = new Genre();
        g.setName(name);

        return g;

    }


}
