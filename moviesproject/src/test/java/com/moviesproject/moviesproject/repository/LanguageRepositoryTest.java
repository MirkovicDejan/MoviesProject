package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Genere;
import com.moviesproject.moviesproject.model.Language;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class LanguageRepositoryTest {

    @Autowired
    private  LanguageRepository repository;

    @Autowired
    protected TestEntityManager entityManager;

    @Test
    public void getAll() {
        int size = repository.findAll().size();
        assertThat(size).isGreaterThan(0);
    }

    @Test
    public void save() {
        int sizeBeforeSave = repository.findAll().size();
        Language language = new Language();
        language.setName("Example");
        entityManager.persist(language);
        entityManager.flush();
        // when
        Language found = repository.findByName("Example");
        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(language.getName());
        //size
        int sizeAfterSize = repository.findAll().size();
        assertThat(sizeAfterSize).isGreaterThan(sizeBeforeSave);
    }

    @Test
    public void findOne() {
        Optional<Language> language = repository.findById(101);
        if (language.isPresent()) {
            assertThat(language.get()).isNotNull();
            assertThat(language.get().getLanguageId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Language> l = repository.findById(101);
        if (l.isPresent()) {
            l.get().setName("Change");
            Optional<Language> l1 = repository.findById(101);
            assertThat(l1.get()).isEqualTo(l.get());
        }
    }

    @Test
    public void delete() {
        Integer id = 101;
        boolean isExistBeforeDelete = repository.findById(id).isPresent();
        repository.deleteById(id);
        boolean notExistAfterDelete = repository.findById(id).isPresent();
        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);
    }
}