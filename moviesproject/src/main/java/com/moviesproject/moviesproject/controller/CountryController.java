package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOCountry;
import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping("/createCountry")
    public Country createCountry (@RequestBody DTOCountry dtoCountry) throws Exception {
        return countryService.save(dtoCountry.createCountry());
    }

    @GetMapping("/findAllCountry")
    public List<Country> findAllCountry(){
        return  countryService.findAllCountry();
    }

    @GetMapping("/findOneCountry")
    public Country findCountryByID(@RequestParam Integer id){
        return countryService.findCountryById(id);
    }

    @PutMapping("/updateCountry")
    public Country updateCountry(@RequestParam Integer id,@RequestParam String name){
        Country find = countryService.findCountryById(id);
        find.setName(name);
        return countryService.update(find);
    }

    @DeleteMapping("/deleteCountry")
    public String deleteCountry(@RequestParam Integer id){
        countryService.delete(id);
        return "Country with id : "+String.valueOf(id)+" is delete !";
    }

}
