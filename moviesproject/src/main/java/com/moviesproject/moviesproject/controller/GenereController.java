package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOGenere;
import com.moviesproject.moviesproject.model.Genre;
import com.moviesproject.moviesproject.service.GenereService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenereController {

    private final GenereService genereService;

    @PostMapping("/createGenere")
    public Genre createGenere(@RequestBody DTOGenere dtoGenere) {
        return genereService.save(dtoGenere.createGenere());
    }

    @GetMapping("/getAllGenere")
    public List<Genre> getAllGenere() {
        return genereService.getAll();
    }

    @GetMapping("/getOneGenere")
    public Genre getOneGenere(@RequestParam Integer id) {
        return genereService.findOneGenere(id);
    }

    @PutMapping("/updateGenere")
    public Genre updateGenere(@RequestParam Integer id, @RequestParam String name) {
        Genre find = genereService.findOneGenere(id);
        find.setName(name);
        return genereService.update(find);
    }

    @DeleteMapping("/deleteGenere")
    public String deleteGenere(@RequestParam Integer id) {
        genereService.delete(id);
        return "Genere with id : " + String.valueOf(id) + "is delete !";
    }
}
