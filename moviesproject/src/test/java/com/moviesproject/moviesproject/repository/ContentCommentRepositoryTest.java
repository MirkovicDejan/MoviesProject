package com.moviesproject.moviesproject.repository;

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
class ContentCommentRepositoryTest {

    @Autowired
    private ContentCommentRepository repository;
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
        ContentComment cm = new ContentComment();
        entityManager.persist(cm);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<ContentComment> cm = repository.findById(101);
        if (cm.isPresent()) {
            assertThat(cm.get()).isNotNull();
            assertThat(cm.get().getCommentId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<ContentComment> cm = repository.findById(101);
        if (cm.isPresent()) {
            cm.get().setComment("This is a changed comment");
            ContentComment save = repository.save(cm.get());
            Optional<ContentComment> cm2 = repository.findById(101);
            assertThat(cm2.get().getComment()).isEqualTo(save.getComment());
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
