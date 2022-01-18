package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.model.Language;
import com.moviesproject.moviesproject.repository.ContentRepository2;
import com.moviesproject.moviesproject.service.ContentService;
import com.moviesproject.moviesproject.service.ContentTypeService;
import com.moviesproject.moviesproject.service.CountryService;
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
public class ContentTest implements MethodsForTestingJUnit{

    private final ContentService contentService;
    private final ContentRepository2 contentRepository2;
    private final CountryService countryService;
    private final ContentTypeService contentTypeService;
    private final LanguageService languageService;

    @Autowired
    public ContentTest(ContentService contentService, ContentRepository2 contentRepository2, CountryService countryService, ContentTypeService contentTypeService, LanguageService languageService) {
        this.contentService = contentService;
        this.contentRepository2 = contentRepository2;
        this.countryService = countryService;
        this.contentTypeService = contentTypeService;
        this.languageService = languageService;
    }

    @Override
    @Test
    public void create() throws Exception {
        Country countryC = countryService.findCountryById(9);
        ContentType contentTypeC = contentTypeService.find(11);
        Language languageC = languageService.findOneLanguage(7);
        Content c = new Content(contentTypeC, countryC, languageC, "supermen", 2000, 90, null, 10, null, null);
        contentService.createContent(c);
    }

    @Override
    @Test
    public void delete() {
        contentRepository2.deleteById(14);
    }

    @Override
    @Test
    public void find() {
        Content c = contentService.findOneContent(14);
        System.out.println(c.getTitle());
    }

    @Override
    @Test
    public void update() throws Exception {
        Content cf = contentService.findOneContent(14);
        cf.setTitle("SEUPERMEN");
        contentService.createContent(cf);
    }
}
