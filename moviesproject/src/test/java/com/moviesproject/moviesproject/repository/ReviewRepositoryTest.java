package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.Review;
import com.moviesproject.moviesproject.model.User;
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
class ReviewRepositoryTest {

    @Autowired
    private  ReviewRepository repository;
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
        Review r = new Review();
        entityManager.persist(r);
        entityManager.flush();
        int afterSavesSize = repository.findAll().size();
        assertThat(afterSavesSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<Review> r = repository.findById(101);
        if (r.isPresent()) {
            assertThat(r.get()).isNotNull();
            assertThat(r.get().getReviewId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        User userUpdate = new User();
        userUpdate.setUserName("Uu4");
        Optional<Review> r = repository.findById(104);
        if (r.isPresent()) {
            r.get().setUser(userUpdate);
            Review save = repository.save(r.get());
            Optional<Review> r2 = repository.findById(104);
            assertThat(r2.get().getUser()).isEqualTo(save.getUser());
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