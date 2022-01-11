package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.model.MovieRole;
import com.moviesproject.moviesproject.model.Season;
import com.moviesproject.moviesproject.model.SerieCast;
import lombok.Data;

@Data
public class DTOSerieCast {

    private Season season;
    private MovieRole movieRole;
    private MoviePeople moviePeople;

    public SerieCast createSerieCast(){
        SerieCast serieCast = new SerieCast();
        serieCast.setSeason(season);
        serieCast.setMovieRole(movieRole);
        serieCast.setMoviePeople(moviePeople);
        return serieCast;
    }
}
