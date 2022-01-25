package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping("/find-all-user-role")
    public List<UserRole>findAll(){
        return userRoleService.findAll();
    }

}
