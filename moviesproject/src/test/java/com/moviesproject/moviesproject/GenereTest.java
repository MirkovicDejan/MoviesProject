package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.Genere;
import com.moviesproject.moviesproject.service.GenereService;
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
public class GenereTest implements MethodsForTestingJUnit{

    private final GenereService genereService;

    @Autowired
    public GenereTest(GenereService genereService) {
        this.genereService = genereService;
    }

    @Override
    @Test
    public void create() throws Exception {
        Genere genere = new Genere();
        genere.setName("genere");
        genereService.save(genere);
    }

    @Override
    @Test
    public void delete() {
      genereService.delete(18);
    }

    @Override
    @Test
    public void find() {
    Genere gf = genereService.findOneGenere(18);
        System.out.println(gf.getName());
    }

    @Override
    @Test
    public void update() throws Exception {
     Genere gu = genereService.findOneGenere(18);
     gu.setName("genere3");
     genereService.save(gu);
    }
}
