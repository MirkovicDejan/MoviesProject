package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentComment;
import com.moviesproject.moviesproject.model.Country;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountryRepositoryTest extends AbstractRepository {

    @Autowired
    private CountryRepository repository;


    @Test
    public void getAll() {
        int size = repository.findAll().size();
        assertThat(size).isGreaterThan(0);
    }

    @Test
    public void save() {
        int sizeBeforeSave = repository.findAll().size();
        Country country = new Country();
        country.setName("Srbija");
        country.setCode("SRB".toCharArray());
        entityManager.persist(country);
        entityManager.flush();

        // when
        //Country found = repository.findByName("ADMIN");

        // then
        //assertThat(found).isNotNull();
        //assertThat(found.getName()).isEqualTo(role.getName());

        //size
        int sizeAfterSave = repository.findAll().size();
        assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    public void findOne() {
        Optional<Country> c = repository.findById(101);
        if (c.isPresent()) {
            assertThat(c.get()).isNotNull();
            assertThat(c.get().getCountryId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Country> c = repository.findById(101);
        if (c.isPresent()) {
            c.get().setName("Change");
            Optional<Country> c2 = repository.findById(101);
            assertThat(c2.get()).isEqualTo(c.get());
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