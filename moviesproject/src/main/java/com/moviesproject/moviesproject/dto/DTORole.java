package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.Role;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class DTORole {
    private String name;

    public static DTORole entityRoleToDTO(Role role) {
        DTORole dto = new DTORole();
        dto.setName(role.getName());
        return dto;
    }

    public static Role DTORoleToEntityRole(DTORole dtoRole) {
        Role role = new Role();
        role.setName(dtoRole.getName());
        return role;
    }

    public static List<DTORole> entityToListDTORole(List<Role> listEntity) {
        return listEntity.stream().map(x -> entityRoleToDTO(x)).collect(Collectors.toList());
    }
}
