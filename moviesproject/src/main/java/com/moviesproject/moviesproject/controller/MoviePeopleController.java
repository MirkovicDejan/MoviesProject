package com.moviesproject.moviesproject.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.moviesproject.moviesproject.dto.DTOMoviePeople;
import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.service.MoviePeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MoviePeopleController {

    private final MoviePeopleService moviePeopleService;

    @PostMapping("/createMoviePeople")
    public MoviePeople createMoviePeople(@RequestBody DTOMoviePeople dtoMoviePeople){
        return moviePeopleService.save(dtoMoviePeople.createMoviePeople());
    }

    @GetMapping("/findOneMoviePeople")
    public MoviePeople findOneMoviePeople(@RequestParam Integer id){
        return moviePeopleService.findOneMoviePeople(id);
    }

    @GetMapping("/findAllMoviePeople")
    public List<MoviePeople> findAllMoviePeople(){
        return moviePeopleService.findAllMoviePeople();
    }

    @PutMapping("/updateMoviePeople")
    public MoviePeople updateMoviePeople(@RequestParam Integer id,@RequestBody DTOMoviePeople dtoMoviePeople){
        return moviePeopleService.updateMoviePeople(id,dtoMoviePeople.createMoviePeople());
    }
    @DeleteMapping("/deleteMoviePeople")
    public String deleteMoviePeople(@RequestParam Integer id){
         moviePeopleService.deleteMoviePeople(id);
         return "Person with id : "+String.valueOf(id)+" is delete !";
    }





}
