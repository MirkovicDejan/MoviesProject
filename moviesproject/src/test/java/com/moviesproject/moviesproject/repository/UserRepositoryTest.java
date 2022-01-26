package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentType;
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
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

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
        User user = new User();
        entityManager.persist(user);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<User> user = repository.findById(103);
        if (user.isPresent()) {
            assertThat(user.get()).isNotNull();
            assertThat(user.get().getUserId()).isEqualTo(103);
        }
    }

    @Test
    public void update() {
        Optional<User> user = repository.findById(101);
        if (user.isPresent()) {
            user.get().setUserName("Update");
            User save = repository.save(user.get());
            Optional<User> user1 = repository.findById(101);
            assertThat(user1.get().getUserName()).isEqualTo(save.getUserName());
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