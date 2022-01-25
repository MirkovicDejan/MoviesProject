package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Genere;
import com.moviesproject.moviesproject.model.Role;
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
class GenereRepositoryTest {

    @Autowired
    private GenereRepository repository;
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
        Genere genere = new Genere();
        genere.setName("Example");
        entityManager.persist(genere);
        entityManager.flush();
        // when
        Genere found = repository.findByName("Example");
        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(genere.getName());
        //size
        int sizeAfterSize = repository.findAll().size();
        assertThat(sizeAfterSize).isGreaterThan(sizeBeforeSave);
    }

    @Test
    public void findOne() {
        Optional<Genere> genere = repository.findById(101);
        if (genere.isPresent()) {
            assertThat(genere.get()).isNotNull();
            assertThat(genere.get().getGenereId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Genere> genere = repository.findById(101);
        if (genere.isPresent()) {
            genere.get().setName("Change");
            Optional<Genere> genere1 = repository.findById(101);
            assertThat(genere1.get()).isEqualTo(genere.get());
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