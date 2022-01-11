package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Country;
import lombok.Data;

@Data
public class DTOCountry {

    private String name;
    private char code[];

    public Country createCountry() {

        Country c = new Country();
        c.setName(name);
        c.setCode(code);

        return c;
    }


}
