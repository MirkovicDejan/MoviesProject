package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.model.UserRole;
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
class UserRoleRepositoryTest {
    @Autowired
    private UserRoleRepository repository;
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
        UserRole ur = new UserRole();
        entityManager.persist(ur);
        entityManager.flush();
        int afterSaveSize = repository.findAll().size();
        assertThat(afterSaveSize).isGreaterThan(beforeSaveSize);
    }

    @Test
    public void findOne() {
        Optional<UserRole> ur = repository.findById(101);
        if (ur.isPresent()) {
            assertThat(ur.get()).isNotNull();
            assertThat(ur.get().getUserRoleId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Role r = new Role();
        r.setName("Update");
        Optional<UserRole> ur = repository.findById(101);
        if (ur.isPresent()) {
            ur.get().setRole(r);
            UserRole save = repository.save(ur.get());
            Optional<UserRole> ur2 = repository.findById(101);
            assertThat(ur2.get().getRole()).isEqualTo(save.getRole());
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