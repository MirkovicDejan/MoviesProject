package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Genere;
import lombok.Data;

@Data
public class DTOGenere {

    private String name;

    public Genere createGenere(){

        Genere g = new Genere();
        g.setName(name);

        return g;

    }


}
