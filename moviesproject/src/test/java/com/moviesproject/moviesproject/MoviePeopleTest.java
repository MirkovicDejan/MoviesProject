package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.MoviePeople;
import com.moviesproject.moviesproject.service.MoviePeopleService;
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
public class MoviePeopleTest implements MethodsForTestingJUnit {

    private final MoviePeopleService moviePeopleService;

    @Autowired
    public MoviePeopleTest(MoviePeopleService moviePeopleService) {
        this.moviePeopleService = moviePeopleService;
    }

    @Override
    @Test
    public void create() throws Exception {
        MoviePeople mp = new MoviePeople();
        mp.setFirstName("D");
        mp.setLastName("M");
        mp.setGender('1');
        mp.setBrithDate(null);
        moviePeopleService.save(mp);
    }

    @Override
    @Test
    public void delete() {
        moviePeopleService.deleteMoviePeople(16);
    }

    @Override
    @Test
    public void find() {
        MoviePeople mp = moviePeopleService.findOneMoviePeople(16);
        System.out.println(mp.getFirstName());
    }

    @Override
    @Test
    public void update() throws Exception {
        MoviePeople mu = moviePeopleService.findOneMoviePeople(16);
        mu.setFirstName("ACTORRR");
        moviePeopleService.save(mu);
    }
}
