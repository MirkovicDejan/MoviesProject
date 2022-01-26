package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Genre;
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
class GenreRepositoryTest {

    @Autowired
    private GenreRepository repository;
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
        Genre genre = new Genre();
        genre.setName("Example");
        entityManager.persist(genre);
        entityManager.flush();
        // when
        Genre found = repository.findByName("Example");
        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(genre.getName());
        //size
        int sizeAfterSize = repository.findAll().size();
        assertThat(sizeAfterSize).isGreaterThan(sizeBeforeSave);
    }

    @Test
    public void findOne() {
        Optional<Genre> genere = repository.findById(101);
        if (genere.isPresent()) {
            assertThat(genere.get()).isNotNull();
            assertThat(genere.get().getGenereId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Genre> genere = repository.findById(101);
        if (genere.isPresent()) {
            genere.get().setName("Change");
            Genre save = repository.save(genere.get());
            Optional<Genre> genere1 = repository.findById(101);
            assertThat(genere1.get().getName()).isEqualTo(save.getName());
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

    @Test
    void getByName() {
        Genre genre = repository.findByName("ACTIONS");

        assertThat(genre).isNotNull();
        assertThat(genre.getGenereId()).isEqualTo(10);
    }
}
