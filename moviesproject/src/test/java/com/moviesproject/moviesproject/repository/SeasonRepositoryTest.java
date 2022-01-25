package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Season;
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
class SeasonRepositoryTest {

    @Autowired
    private SeasonRepository repository;

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
        Season season = new Season();
        entityManager.persist(season);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<Season> s = repository.findById(102);
        if (s.isPresent()) {
            assertThat(s.get()).isNotNull();
            assertThat(s.get().getSeasonId()).isEqualTo(102);
        }
    }

    @Test
    public void update() {
        Optional<Season> s = repository.findById(101);
        if (s.isPresent()) {
            s.get().setName("Changed");
            Optional<Season> s2 = repository.findById(101);
            assertThat(s2.get()).isEqualTo(s2.get());
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
