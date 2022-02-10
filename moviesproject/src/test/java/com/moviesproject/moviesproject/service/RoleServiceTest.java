package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class RoleServiceTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void create() {
        //get size of database before save
        int sizeBeforeSave = roleRepository.findAll().size();
        //create some role for example, doesn't meter values !
        Role role = new Role();
        role.setName("TEST_ROLE");
        //save role and get values of saved role
        Role save = roleRepository.save(role);
        //get size after save
        int sizeAfterSave = roleRepository.findAll().size();
        //check
        assertThat(save).isNotNull();
        assertThat(save).isEqualTo(role);
        assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    void all() {
        int finalSize = 100;
        Integer size = roleRepository.findAll().size();
        assertThat(size).isNotZero();
        assertThat(size).isNotNegative();
        assertThat(size).isNotEqualTo(finalSize);
        assertThat(size).isLessThan(finalSize);
    }

    @Test
    void allWithPage() {
        int finalSize = 100;
        Integer size = roleRepository.findAll().size();
        assertThat(size).isNotZero();
        assertThat(size).isNotNegative();
        assertThat(size).isNotEqualTo(finalSize);
        assertThat(size).isLessThan(finalSize);
    }

    @Test
    void update() {
        //Data's for example, doesn't meters values
        Integer roleId = 2;
        String roleNameForUpdate = "Example";
        //when
        Role roleForUpdate = roleRepository.findById(3).get();
        assertThat(roleForUpdate.getName()).isNotEqualTo(roleNameForUpdate);
        //then
        roleForUpdate.setRoleId(roleId);
        roleForUpdate.setName(roleNameForUpdate);
        Role check = roleRepository.save(roleForUpdate);
        assertThat(check.getName()).isEqualTo(roleNameForUpdate);
        assertThat(roleRepository.count()).isEqualTo(5);
    }

    @Test
    void one() {
        Integer id = 1;
        Role role = roleRepository.findById(id).get();
        assertThat(role).isNotNull();
        assertThat(role.getRoleId()).isEqualTo(id);
        assertThat(role).isExactlyInstanceOf(Role.class);
        assertThat(role.getName()).isEqualTo("TEST");
    }

    @Test
    void delete() {
        Integer id = 2;
        roleRepository.deleteById(id);
        assertThat(roleRepository.count()).isEqualTo(4);
    }

    @Test
    void existsByName(){
        String name = "ADMIN";
        boolean existsName = roleRepository.existsByName(name);
        assertThat(existsName).isNotNull();
        assertThat(existsName).isTrue();
    }
}