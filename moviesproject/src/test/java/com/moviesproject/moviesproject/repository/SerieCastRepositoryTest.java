package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.model.MovieRole;
import com.moviesproject.moviesproject.model.SerieCast;
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
class SerieCastRepositoryTest {

    @Autowired
    private SerieCastRepository repository;
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
        SerieCast sc = new SerieCast();
        entityManager.persist(sc);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<SerieCast> sc = repository.findById(101);
        if (sc.isPresent()) {
            assertThat(sc.get()).isNotNull();
            assertThat(sc.get().getSerieCastId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        MovieRole mr = new MovieRole();
        mr.setName("Update");
        Optional<SerieCast> sc = repository.findById(101);
        if (sc.isPresent()) {
            sc.get().setMovieRole(mr);
            SerieCast save = repository.save(sc.get());
            Optional<SerieCast> sc2 = repository.findById(101);
            assertThat(sc2.get().getMovieRole()).isEqualTo(save.getMovieRole());
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