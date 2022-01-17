package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import com.moviesproject.moviesproject.service.RoleService;
import com.moviesproject.moviesproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("qa")
@TestPropertySource(locations = "classpath:application-qa.properties")
public class UserRoleTest implements MethodsForTestingJUnit {

    private final UserRoleRepository userRoleRepository;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserRoleTest(UserRoleRepository userRoleRepository, UserService userService, RoleService roleService) {
        this.userRoleRepository = userRoleRepository;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    @Test
    public void create() {
        UserRole userRole = new UserRole();
        User user = userService.findOneUsre(3);
        Role role = roleService.findOneRole(2);
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleRepository.save(userRole);
    }

    @Override
    @Test
    public void delete() {
        userRoleRepository.deleteById(6);
    }

    @Override
    @Test
    public void find() {
        Optional<UserRole> ur = userRoleRepository.findById(6);
        System.out.println(ur.get().toString());
    }

    @Override
    @Test
    public void update() {
        Optional<UserRole> ur = userRoleRepository.findById(6);
        ur.get().getRole().setName("user");
        userRoleRepository.save(ur.get());
    }
}
