package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // anotacija za parametrizovani konstruktor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country save(Country country) throws Exception {
        if (country.getCode().length <= 10) {
            return countryRepository.save(country);
        }
        throw new Exception("Your length is to long !");
    }

    public List<Country> findAllCountry() {
        List<Country> all = countryRepository.findAll();
        return all;
    }

    public Country findCountryById(Integer id) {
        Optional<Country> cf = countryRepository.findById(id);
        if (cf.isPresent()) {
            return cf.get();
        }
        return null;
    }

    public Country update(Country find) {
        return countryRepository.save(find);
    }

    public String delete(Integer id) {
        countryRepository.deleteById(id);
        return "Country with id : " + String.valueOf(id) + " is delete !";
    }
}
