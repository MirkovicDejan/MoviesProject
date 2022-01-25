package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.ContentComment;
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
class ContentRepository2Test {

    @Autowired
    private ContentRepository2 repository;
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
        Content content = new Content();
        entityManager.persist(content);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<Content> c = repository.findById(101);
        if (c.isPresent()) {
            assertThat(c.get()).isNotNull();
            assertThat(c.get().getContentId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Content> c = repository.findById(101);
        if (c.isPresent()) {
            c.get().setDuration(50);
            Content save = repository.save(c.get());
            Optional<Content> c2 = repository.findById(101);
            assertThat(c2.get().getDuration()).isEqualTo(save.getDuration());
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
