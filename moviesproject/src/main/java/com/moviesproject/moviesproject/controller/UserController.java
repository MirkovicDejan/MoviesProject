package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save-user")
    public User saveUser(@RequestBody DTOUser dtoUser) {
        return userService.saveUser(dtoUser);
    }

    @GetMapping("/all-users")
    public List<DTOUser> all(){
        return userService.all();
    }

    @GetMapping("/find-one")
    public DTOUser one(@RequestParam Integer id){
     return userService.one(id);
    }


}
