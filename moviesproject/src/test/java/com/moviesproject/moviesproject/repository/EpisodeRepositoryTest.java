package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Episode;
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
class EpisodeRepositoryTest {

    @Autowired
    private EpisodeRepository repository;
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
        Episode e = new Episode();
        entityManager.persist(e);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<Episode> e = repository.findById(101);
        if (e.isPresent()) {
            assertThat(e.get()).isNotNull();
            assertThat(e.get().getEpisodeId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Episode> e = repository.findById(101);
        if (e.isPresent()) {
            e.get().setName("Change");
            Optional<Episode> e2 = repository.findById(101);
            assertThat(e2.get()).isEqualTo(e.get());
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
