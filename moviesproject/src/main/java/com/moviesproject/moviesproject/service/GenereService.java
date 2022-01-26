package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Genre;
import com.moviesproject.moviesproject.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenereService {

    private final GenreRepository genreRepository;

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> getAll() {
        List<Genre> all = genreRepository.findAll();
        return all;
    }

    public Genre findOneGenere(Integer id) {
        Optional<Genre> g = genreRepository.findById(id);
        if (g.isPresent()) {
            return g.get();
        }
        return null;
    }

    public Genre update(Genre find) {
        return genreRepository.save(find);
    }

    public String delete(Integer id) {
        genreRepository.deleteById(id);
        return "Genere with id : " + String.valueOf(id) + "is delete !";
    }
}
