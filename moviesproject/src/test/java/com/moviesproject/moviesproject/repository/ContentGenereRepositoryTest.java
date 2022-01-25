package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentComment;
import com.moviesproject.moviesproject.model.ContentGenere;
import com.moviesproject.moviesproject.model.Genere;
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
class ContentGenereRepositoryTest {

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
        ContentGenere cg = new ContentGenere();
        entityManager.persist(cg);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<ContentGenere> cg = repository.findById(101);
        if (cg.isPresent()) {
            assertThat(cg.get()).isNotNull();
            assertThat(cg.get().getContentGenereId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Genere g = new Genere();
        g.setName("Change");
        Optional<ContentGenere> cg = repository.findById(101);
        if (cg.isPresent()) {
            cg.get().setGenere(g);
            Optional<ContentGenere> cg2 = repository.findById(101);
            assertThat(cg.get()).isEqualTo(cg2.get());
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