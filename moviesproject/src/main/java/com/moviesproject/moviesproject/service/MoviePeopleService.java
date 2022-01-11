package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.dto.DTOMoviePeople;
import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.repository.MoviePeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviePeopleService {

    private final MoviePeopleRepository moviePeopleRepository;

    public MoviePeople save(MoviePeople moviePeople) {

        return moviePeopleRepository.save(moviePeople);
    }

    public MoviePeople findOneMoviePeople(Integer id) {
        Optional<MoviePeople> mp = moviePeopleRepository.findById(id);
        if (mp.isPresent()) {
            return mp.get();
        }
        return null;
    }

    public List<MoviePeople> findAllMoviePeople() {
        return moviePeopleRepository.findAll();
    }

    public MoviePeople updateMoviePeople(Integer id,MoviePeople moviePeople) {
        MoviePeople mv = findOneMoviePeople(id);
        mv.setFirstName(moviePeople.getFirstName());
        mv.setLastName(moviePeople.getLastName());
        mv.setBrithDate(moviePeople.getBrithDate());
        mv.setGender(moviePeople.getGender());
        return moviePeopleRepository.save(mv);
    }

    public String deleteMoviePeople(Integer id) {
        moviePeopleRepository.deleteById(id);
        return "Person with id : "+String.valueOf(id)+" is delete !";
    }
}
