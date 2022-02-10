package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.repository.RoleRepository;
import com.moviesproject.moviesproject.repository.UserRepository;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRoleServiceTest {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Test
    void create() {
        //Find User and Role for entity UserRole
        User u = userRepository.findById(3).get();
        Role r = roleRepository.findById(3).get();
        //Check size before size
        int sizeBeforeSize = userRoleRepository.findAll().size();
        //Create UserRole
        UserRole ur = new UserRole();
        ur.setUser(u);
        ur.setRole(r);
        //Save
        UserRole checkUserRole = userRoleRepository.save(ur);
        int sizeAfterSave = roleRepository.findAll().size();
        //check
        assertThat(checkUserRole).isNotNull();
        assertThat(checkUserRole).isEqualTo(ur);
        assertThat(checkUserRole).isExactlyInstanceOf(UserRole.class);
        assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSize);
    }

    @Test
    void findAll() {
        int finalSize = 100;
        Integer size = userRoleRepository.findAll().size();
        assertThat(size).isNotZero();
        assertThat(size).isNotNegative();
        assertThat(size).isNotEqualTo(finalSize);
        assertThat(size).isLessThan(finalSize);
    }

    @Test
    void findOneUserRole() {
        Integer idUserRole = 3;
        UserRole userRole = userRoleRepository.findById(idUserRole).get();
        User userCheck = userRepository.findById(3).get();
        Role roleCheck = roleRepository.findById(4).get();
        assertThat(userRole).isNotNull();
        assertThat(userCheck).isNotNull();
        assertThat(roleCheck).isNotNull();
        assertThat(userRole.getUserRoleId()).isEqualTo(idUserRole);
        assertThat(userRole.getUser()).isNotNull();
        assertThat(userRole.getRole()).isNotNull();
        assertThat(userRole.getUser()).isEqualTo(userCheck);
        assertThat(userRole.getRole()).isEqualTo(roleCheck);

    }

    @Test
    void delete() {
        userRoleRepository.deleteById(2);
        assertThat(userRoleRepository.count()).isEqualTo(3);
    }

    @Test
    void updateUserRole() {
        Integer userRoleId = 3;
        UserRole userRole = userRoleRepository.findById(3).get();
        User userForUpdate = userRepository.findById(5).get();
        assertThat(userRole).isNotNull();
        assertThat(userForUpdate).isNotNull();
        userRole.setUserRoleId(userRoleId);
        userRole.setUser(userForUpdate);
        UserRole update = userRoleRepository.save(userRole);
        assertThat(update).isNotNull();
        assertThat(update.getUser()).isEqualTo(userForUpdate);
    }

    @Test
    void existsByUser(){
        User user = userRepository.findById(1).get();
        boolean check = userRoleRepository.existsByUser(user);
        assertThat(check).isNotNull();
        assertThat(check).isTrue();
    }

    @Test
    void findByUserName(){

    }
}