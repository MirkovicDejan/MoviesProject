package com.moviesproject.moviesproject.config;


import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.repository.RoleRepository;
import com.moviesproject.moviesproject.repository.UserRepository;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import com.moviesproject.moviesproject.service.RoleService;
import com.moviesproject.moviesproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class InitializeUserInDB implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitializeUserInDB.class);

    @Autowired
    private UserService userService;

    // This is for User
    @Override
    public void run(String... args) throws Exception {
        userService.saveUser(new User("K 1","K 1 ime","K 1 prezime","K 1 adresa","1 tel broj","1 e-mail","1 sira"));
        userService.saveUser(new User("K 2","K 2 ime","K 2 prezime","K 2 adresa","2 tel broj","2 e-mail","2 sira"));
        userService.saveUser(new User("K 3","K 3 ime","K 3 prezime","K 3 adresa","3 tel broj","3 e-mail","3 sira"));
    }
}
