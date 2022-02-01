package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTORole;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private final RoleService roleService;

    @PostMapping("/save-role")
    public DTORole create (@RequestBody DTORole dtoRole){
        return  roleService.create(dtoRole);
    }

    @GetMapping("/get-all-role")
    public List<DTORole>all(){
        return roleService.all();
    }

    @PutMapping("update-role")
    public DTORole update(@RequestParam Integer id, @RequestBody DTORole dtoRole){
        return roleService.update(id,dtoRole);
    }
    @GetMapping("/find-one-role")
    public DTORole one(@RequestParam Integer id){
        return roleService.one(id);
    }
    @DeleteMapping("/delete-role")
    public void delete(@RequestParam Integer id){
        roleService.delete(id);
    }


}
