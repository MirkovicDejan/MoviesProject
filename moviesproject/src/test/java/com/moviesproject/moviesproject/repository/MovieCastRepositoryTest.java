package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.MovieCast;
import com.moviesproject.moviesproject.model.MoviePeople;
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
class MovieCastRepositoryTest {

    @Autowired
    private MovieCastRepository repository;
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
        MovieCast mc = new MovieCast();
        entityManager.persist(mc);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<MovieCast> mc = repository.findById(101);
        if (mc.isPresent()) {
            assertThat(mc.get()).isNotNull();
            assertThat(mc.get().getMovieCastId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        MoviePeople mv = new MoviePeople();
        mv.setFirstName("Change");
        Optional<MovieCast> mc = repository.findById(101);
        if (mc.isPresent()) {
            mc.get().setMoviePeople(mv);
            Optional<MovieCast> mc2 = repository.findById(101);
            assertThat(mc2.get()).isEqualTo(mc.get());
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