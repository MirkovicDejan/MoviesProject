package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOGenere;
import com.moviesproject.moviesproject.model.Genere;
import com.moviesproject.moviesproject.service.GenereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GenereController {

    private final GenereService genereService;

    @PostMapping("/createGenere")
    public Genere createGenere(@RequestBody DTOGenere dtoGenere) {
        return genereService.save(dtoGenere.createGenere());
    }

    @GetMapping("/getAllGenere")
    public List<Genere> getAllGenere() {
        return genereService.getAll();
    }

    @GetMapping("/getOneGenere")
    public Genere getOneGenere(@RequestParam Integer id) {
        return genereService.findOneGenere(id);
    }

    @PutMapping("/updateGenere")
    public Genere updateGenere(@RequestParam Integer id, @RequestParam String name) {
        Genere find = genereService.findOneGenere(id);
        find.setName(name);
        return genereService.update(find);
    }

    @DeleteMapping("/deleteGenere")
    public String deleteGenere(@RequestParam Integer id) {
        genereService.delete(id);
        return "Genere with id : " + String.valueOf(id) + "is delete !";
    }
}
