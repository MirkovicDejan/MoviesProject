package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Genere;
import com.moviesproject.moviesproject.repository.GenereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenereService {

    private final GenereRepository genereRepository;

    public Genere save(Genere genere) {
        return genereRepository.save(genere);
    }

    public List<Genere> getAll() {
        List<Genere> all = genereRepository.findAll();
        return all;
    }

    public Genere findOneGenere(Integer id) {
        Optional<Genere> g = genereRepository.findById(id);
        if (g.isPresent()) {
            return g.get();
        }
        return null;
    }

    public Genere update(Genere find) {
        return genereRepository.save(find);
    }

    public String delete(Integer id) {
        genereRepository.deleteById(id);
        return "Genere with id : " + String.valueOf(id) + "is delete !";
    }
}
