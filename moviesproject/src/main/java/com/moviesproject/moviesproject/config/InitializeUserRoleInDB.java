package com.moviesproject.moviesproject.config;

import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import com.moviesproject.moviesproject.service.RoleService;
import com.moviesproject.moviesproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializeUserRoleInDB implements CommandLineRunner {

    @Autowired
    private final UserRoleRepository userRoleRepository;
    @Autowired
    private final UserService userService;
    @Autowired
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        User user = userService.findOneUsre(3);
        userRoleRepository.save(new UserRole(roleService.findOneRole(1),user));
    }
}
