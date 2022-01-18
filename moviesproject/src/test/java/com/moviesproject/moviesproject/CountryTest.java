package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("qa")
@TestPropertySource(locations = "classpath:application-qa.properties")
public class CountryTest implements MethodsForTestingJUnit {

    private final CountryService countryService;

    @Autowired
    public CountryTest(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @Test
    public void create() throws Exception {
        Country country = new Country();
        String code = "666";
        country.setName("USA");
        country.setCode(code.toCharArray());
        countryService.save(country);
    }

    @Override
    @Test
    public void delete() {

    }

    @Override
    @Test
    public void find() {
        countryService.findCountryById(9);

    }

    @Override
    @Test
    public void update() throws Exception {
        Country findCountryforUpdate = countryService.findCountryById(9);
        findCountryforUpdate.setName("GERMANY");
        countryService.save(findCountryforUpdate);
    }
}
