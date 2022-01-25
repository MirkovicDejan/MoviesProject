package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Content;
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
class MoviePeopleRepositoryTest {
    @Autowired
    private  MoviePeopleRepository repository;
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
        MoviePeople mp = new MoviePeople();
        entityManager.persist(mp);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<MoviePeople> mp = repository.findById(101);
        if (mp.isPresent()) {
            assertThat(mp.get()).isNotNull();
            assertThat(mp.get().getMoviePeopleID()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<MoviePeople> mc = repository.findById(101);
        if (mc.isPresent()) {
            mc.get().setFirstName("Changed");
            MoviePeople save =  repository.save(mc.get());
            Optional<MoviePeople> mc2 = repository.findById(101);
            assertThat(mc2.get().getFirstName()).isEqualTo(save.getFirstName());
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