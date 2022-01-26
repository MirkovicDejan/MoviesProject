package com.moviesproject.moviesproject.repository;


import com.moviesproject.moviesproject.model.ContentGenre;
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
class ContentGenreRepositoryTest {

    @Autowired
    private ContentGenereRepository repository;
    @Autowired
    protected TestEntityManager entityManager;

    @Test
    public void getAll() {
        int size = repository.findAll().size();
        assertThat(size).isGreaterThan(0);
    }

    @Test
    public void save() {
        int beforeSaveSize = repository.findAll().size();
        ContentGenre cg = new ContentGenre();
        entityManager.persist(cg);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<ContentGenre> cg = repository.findById(101);
        if (cg.isPresent()) {
            assertThat(cg.get()).isNotNull();
            assertThat(cg.get().getContentGenereId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Genre g = new Genre();
        g.setName("Change");
        Optional<ContentGenre> cg = repository.findById(101);
        if (cg.isPresent()) {
            cg.get().setGenre(g);
            ContentGenre save = repository.save(cg.get());
            Optional<ContentGenre> cg2 = repository.findById(101);
            assertThat(cg2.get().getContent()).isEqualTo(save.getContent());
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
