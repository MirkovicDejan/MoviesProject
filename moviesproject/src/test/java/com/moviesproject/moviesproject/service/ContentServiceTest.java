package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.model.Language;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ContentServiceTest {

    @Autowired
    private ContentService service;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ContentTypeService contentTypeService;
    @Autowired
    private LanguageService languageService;

    @Test
    void createContent() {
        int sizeBeforeSave = service.findAllContent().size();

        Country countryFound = countryService.findCountryById(101);
        ContentType contentTypeFound = contentTypeService.find(101);
        Language languageFound = languageService.findOneLanguage(101);
        Content content = new Content();
        content.setCountry(countryFound);
        content.setContentType(contentTypeFound);
        content.setLanguage(languageFound);
        content.setDuration(100);
        content.setReleaseDate(new Date(2000 - 15 - 02));
        content.setRating(7);
        content.setTrailerLink(null);
        content.setCoverLink(null);
        content.setYear(2000);
        content.setTitle("Something");
        Content saved = service.createContent(content);

        int sizeAfterSave = service.findAllContent().size();

        assertThat(saved).isNotNull();
        assertThat(saved.getCountry()).isEqualTo(content.getCountry());
        assertThat(saved.getLanguage()).isEqualTo(content.getLanguage());
        assertThat(saved.getContentType()).isEqualTo(content.getContentType());
        assertThat(saved.getReleaseDate()).isEqualTo(content.getReleaseDate());
        assertThat(saved.getDuration()).isEqualTo(content.getDuration());
        assertThat(saved.getRating()).isEqualTo(content.getRating());
        assertThat(saved.getTitle()).isEqualTo(content.getTitle());

        assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    void findOneContent() {
        Integer id = 102;
        Content oneContent = service.findOneContent(id);
        assertThat(oneContent).isNotNull();
        assertThat(oneContent.getContentId()).isEqualTo(id);

    }

    @Test
    void findAllContent() {
        int allSize = service.findAllContent().size();
        assertThat(allSize).isGreaterThan(0);
        int check = service.findAllContent().size();
        assertThat(allSize).isEqualTo(check);
    }

    @Test
    void updateContent() {
        Integer id = 102;
        Content contentForUpdate = service.findOneContent(id);
        contentForUpdate.setTitle("Update title");
        service.updateContent(id,contentForUpdate);
        Content check = service.findOneContent(id);
        assertThat(check).isEqualTo(contentForUpdate);
    }

    @Test
    void findContentByRating() {
        List<Content>byRating = service.findContentByRating();
        assertThat(service.findContentByRating()).isEqualTo(byRating);
    }

    @Test
    void findContentByReleaseDate() {
        List<Content>DESC= service.findContentByReleaseDate();
        assertThat(service.findContentByReleaseDate()).isEqualTo(DESC);
    }
}
