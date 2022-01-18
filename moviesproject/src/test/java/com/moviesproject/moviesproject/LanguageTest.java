package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.Language;
import com.moviesproject.moviesproject.service.LanguageService;
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
public class LanguageTest implements MethodsForTestingJUnit{

    private final LanguageService languageService;

    @Autowired
    public LanguageTest(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    @Test
    public void create() throws Exception {
        Language language = new Language();
        String code="222";
        language.setName("Englisch");
        language.setCode(code.toCharArray());
    }

    @Override
    @Test
    public void delete() {

    }

    @Override
    @Test
    public void find() {
        Language language = languageService.findOneLanguage(8);
        System.out.println(language.getName());
    }

    @Override
    @Test
    public void update() throws Exception {
        Language findLanguageForUpdate = languageService.findOneLanguage(8);
        findLanguageForUpdate.setName("French");
        languageService.save(findLanguageForUpdate);
    }
}
