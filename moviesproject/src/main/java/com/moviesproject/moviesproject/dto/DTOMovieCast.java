package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.MovieCast;
import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.model.MovieRole;
import lombok.Data;

@Data
public class DTOMovieCast {

    private Content content;
    private MovieRole movieRole;
    private MoviePeople moviePeople;

    public MovieCast createMovie() {
        MovieCast mc = new MovieCast();
        mc.setContent(content);
        mc.setMovieRole(movieRole);
        mc.setMoviePeople(moviePeople);
        return mc;
    }
}
