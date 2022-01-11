package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.MovieCast;
import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.model.MovieRole;
import com.moviesproject.moviesproject.repository.MovieCastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCastService {

    private final MovieCastRepository movieCastRepository;

    public MovieCast saveMovie(MovieCast movie) {
        return movieCastRepository.save(movie);
    }

    public MovieCast findOneMovie(Integer id) {
        Optional<MovieCast> mc = movieCastRepository.findById(id);
        if(mc.isPresent()){
            return mc.get();
        }
            return null;
    }

    public MovieCast updateMovie(Integer id, Content content, MovieRole movieRole, MoviePeople moviePeople) {
        MovieCast find = findOneMovie(id);
        find.setContent(content);
        find.setMovieRole(movieRole);
        find.setMoviePeople(moviePeople);
        return  movieCastRepository.save(find);
    }


}
