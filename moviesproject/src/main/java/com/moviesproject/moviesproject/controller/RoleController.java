package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTORole;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/save-role")
    public DTORole create(@RequestBody DTORole dtoRole){
        return roleService.create(dtoRole);
    }

    @GetMapping("/get-all-role")
    public List<DTORole> all() {
        return roleService.all();
    }

    @GetMapping("/get-all-role-page")
    public Page<Role> allWithPage(Pageable pageable) {
        return roleService.allWithPage(pageable);
    }

    @PutMapping("/update-role")
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
