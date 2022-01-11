package com.moviesproject.moviesproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moviesproject.moviesproject.model.MoviePeople;
import lombok.Data;

import java.util.Date;

@Data
public class DTOMoviePeople {

    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date brithDate;
    private char gender;


    public MoviePeople createMoviePeople(){

        MoviePeople mp = new MoviePeople();
        mp.setFirstName(firstName);
        mp.setLastName(lastName);
        mp.setBrithDate(brithDate);
        mp.setGender(gender);

        return mp;

    }



}
