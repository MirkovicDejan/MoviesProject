package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTORole;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/createRole")
    public Role createRole(@RequestBody DTORole dtoRole){
        return roleService.createRole(dtoRole.createRole());
    }

    @GetMapping("/findOneRole")
    public Role findOneRole(@RequestParam Integer id){
        return roleService.findOneRole(id);
    }

    @GetMapping("/finAllRole")
    public List<Role> findAllRole(){
        return roleService.findAllRole();
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestParam Integer id,@RequestParam String name){
        return roleService.updateRole(id,name);
    }

    @DeleteMapping("/deleteRole")
    public String deleteRole(@RequestParam Integer id){
        roleService.deleteRole(id);
        return "Role with id : "+String.valueOf(id)+" is delete !";
    }
}
