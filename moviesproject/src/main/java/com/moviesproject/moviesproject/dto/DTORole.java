package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Role;
import lombok.Data;

@Data
public class DTORole {

    private String name;

    public Role createRole() {
        Role role = new Role();
        role.setName(name);
        return role;
    }
}
