package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.model.Role;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RoleRepositoryTest extends AbstractRepository {

    @Autowired
    private RoleRepository repository;

    @Test
    public void getAll() {
        int size = repository.findAll().size();
        assertThat(size).isGreaterThan(0);
    }

    @Test
    public void save() {
        int sizeBeforeSave = repository.findAll().size();
        Role role = new Role();
        role.setName("SUPER_GUEST");
        entityManager.persist(role);
        entityManager.flush();
        // when
        Role found = repository.findByName("SUPER_GUEST");
        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(role.getName());
        //size
        int sizeAfterSize = repository.findAll().size();
        assertThat(sizeAfterSize).isGreaterThan(sizeBeforeSave);
    }

    @Test
    public void findOne() {
        Optional<Role> r = repository.findById(101);
        if (r.isPresent()) {
            assertThat(r.get()).isNotNull();
            assertThat(r.get().getRoleId()).isEqualTo(101);
        }
    }

    @Test
    public void update() {
        Optional<Role> r = repository.findById(101);
        if (r.isPresent()) {
            r.get().setName("Change");
            Optional<Role> r2 = repository.findById(101);
            assertThat(r2.get()).isEqualTo(r.get());
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