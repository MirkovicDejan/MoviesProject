package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentComment;
import com.moviesproject.moviesproject.model.ContentType;
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
class ContentTypeRepositoryTest {

    @Autowired
    private ContentTypeRepository repository;
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
        ContentType ct = new ContentType();
        entityManager.persist(ct);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<ContentType> ct = repository.findById(101);
        if (ct.isPresent()) {
            assertThat(ct.get()).isNotNull();
            assertThat(ct.get().getContentTypeId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<ContentType> ct = repository.findById(101);
        if (ct.isPresent()) {
            ct.get().setName("Change");
            Optional<ContentType> ct2 = repository.findById(101);
            assertThat(ct.get()).isEqualTo(ct2.get());
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