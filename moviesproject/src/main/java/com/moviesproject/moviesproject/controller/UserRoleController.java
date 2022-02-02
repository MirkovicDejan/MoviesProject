package com.moviesproject.moviesproject.controller;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserRoleController {

    @Autowired
    private final UserRoleService userRoleService;

    @PostMapping("/create-user-role")
    public UserRole createUserRole(@RequestParam Integer roleId, @RequestParam Integer userId) throws Exception {
        return userRoleService.create(roleId, userId);
    }

    @GetMapping("/find-all-user-role")
    public List<UserRole> findAll() {
        return userRoleService.findAll();
    }

    @GetMapping("/find-one-user-role")
    public UserRole findOne(@RequestParam Integer id) throws Exception {
        return userRoleService.findOneUserRole(id);
    }

    @DeleteMapping("/delete-user-role")
    public String delete(@RequestParam Integer id) throws Exception {
         userRoleService.delete(id);
         return  "User role with id : "+id+" is delete !";
    }


    @PutMapping("/update-user-role")
    public UserRole update(@RequestParam Integer userRoleId,@RequestParam Integer roleId,@RequestParam Integer userId) throws Exception {
      return userRoleService.updateUserRole(userRoleId,roleId,userId);

    }
}


