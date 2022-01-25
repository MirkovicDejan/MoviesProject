package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.MoviePeopleRole;
import com.moviesproject.moviesproject.model.MovieRole;
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
class MoviePeopleRoleRepositoryTest {

    @Autowired
    private MoviePeopleRoleRepository repository;
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
        MoviePeopleRole mpr = new MoviePeopleRole();
        entityManager.persist(mpr);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<MoviePeopleRole> mpc = repository.findById(101);
        if (mpc.isPresent()) {
            assertThat(mpc.get()).isNotNull();
            assertThat(mpc.get().getMoviePeopleRoleId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        MovieRole mr = new MovieRole();
        mr.setName("Changed");
        Optional<MoviePeopleRole> mpc = repository.findById(101);
        if (mpc.isPresent()) {
            mpc.get().setMovieRole(mr);
            Optional<MoviePeopleRole> mpc2 = repository.findById(101);
            assertThat(mpc2.get()).isEqualTo(mpc.get());
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