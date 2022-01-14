package com.moviesproject.moviesproject.config;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializeRoleInDB implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitializeRoleInDB.class);

    @Autowired
    private RoleService roleService;
    @Override
    public void run(String... args) throws Exception {
        // This is for Role
        roleService.createRole(new Role("Admin"));
        roleService.createRole(new Role("User"));
    }
}
