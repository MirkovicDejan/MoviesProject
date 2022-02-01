package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.dto.DTORole;
import com.moviesproject.moviesproject.exception.ApiRequestException;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public DTORole create(DTORole dtoRole) {
        Role convertForSave = DTORole.DTORoleToEntityRole(dtoRole); // new solution
        if (!convertForSave.getName().equals(null)) {
            if (convertForSave.getName().toCharArray().length > 30) {
                throw new ApiRequestException("ERROR for name ! Name is to long ! Name must be less then 30 character !");
            } else if (roleRepository.existsByName(convertForSave.getName())) {
                throw new ApiRequestException("Role with name : " + convertForSave.getName() + " exists !");
            } else {
                return DTORole.entityRoleToDTO(roleRepository.save(convertForSave));
            }
        } else {
            throw new ApiRequestException("Object is : EMPTY !!!");
        }
    }

    public List<DTORole> all() {
        List<Role> listRole = roleRepository.findAll();
        if (listRole.isEmpty()) {
            throw new ApiRequestException("No one name for role exists ! Database is empty !");
        }
        return DTORole.entityToListDTORole(listRole);
    }

    public DTORole update(Integer id, DTORole dtoRole) {
        Role convertUpdate = DTORole.DTORoleToEntityRole(dtoRole);
        if (roleRepository.existsById(id)) {
            if (convertUpdate.getName().toCharArray().length > 30) {
                throw new ApiRequestException("Name is to long ! Name must be less than 30 characters !");
            } else if (roleRepository.existsByName(convertUpdate.getName())) {
                throw new ApiRequestException("Role with name : " + convertUpdate.getName() + " exists, insert another name for update !");
            } else {
                convertUpdate.setRoleId(id);
                return DTORole.entityRoleToDTO(roleRepository.save(convertUpdate));
            }
        }
        throw new ApiRequestException("ERROR ! Can't be update, because Role with id : " + id + " don't exists !");
    }

    public DTORole one(Integer id) {
        if(roleRepository.existsById(id)){
            return DTORole.entityRoleToDTO(roleRepository.findById(id).get());
        }else {
            throw new ApiRequestException("Role with id : "+id+" don't exists in database !!!");
        }
    }

    public void delete(Integer id) {
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
        }else {
            throw new ApiRequestException("Role with : "+id+" don't exists in database !");
        }
    }
}

