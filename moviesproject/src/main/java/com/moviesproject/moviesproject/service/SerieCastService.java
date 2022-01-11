package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.model.MovieRole;
import com.moviesproject.moviesproject.model.Season;
import com.moviesproject.moviesproject.model.SerieCast;
import com.moviesproject.moviesproject.repository.SerieCastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SerieCastService {

    private final SerieCastRepository serieCastRepository;

    public SerieCast saveSerie(SerieCast serieCast) {
        return serieCastRepository.save(serieCast);
    }

    public SerieCast findOneSerie(Integer id) {
         Optional<SerieCast> sc = serieCastRepository.findById(id);
         if(sc.isPresent()){
             return sc.get();
         }
             return null;
      }

    public SerieCast updateSerie(Integer id, Season season, MovieRole movieRole, MoviePeople moviePeople) {
        SerieCast findForUpdate = findOneSerie(id);
        findForUpdate.setSeason(season);
        findForUpdate.setMovieRole(movieRole);
        findForUpdate.setMoviePeople(moviePeople);
        return serieCastRepository.save(findForUpdate);
    }


}
