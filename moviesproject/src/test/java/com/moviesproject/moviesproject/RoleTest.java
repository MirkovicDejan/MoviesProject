package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("qa")
@TestPropertySource(locations = "classpath:application-qa.properties")
public class RoleTest implements MethodsForTestingJUnit {

    private final RoleService roleService;

    @Autowired
    public RoleTest(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @Test
    public void create() {
        Role admin2 = new Role("ADMIN 2");
        roleService.createRole(admin2);
    }

    @Override
    @Test
    public void delete() {
        roleService.deleteRole(2);
    }

    @Override
    @Test
    public void find() {
        Role findRole = new Role();
        findRole = roleService.findOneRole(1);
        System.out.println(findRole.getName());
    }

    @Override
    @Test
    public void update() {
        Role findRoleForUpdate = roleService.findOneRole(2);
        findRoleForUpdate.setName("USER");
        roleService.createRole(findRoleForUpdate);
    }
}
