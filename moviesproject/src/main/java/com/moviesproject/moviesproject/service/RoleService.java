package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role findOneRole(Integer id) {
        Optional<Role> r = roleRepository.findById(id);
        if (r.isPresent()) {
            return r.get();
        }
            return null;
    }

    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }

    public Role updateRole(Integer id, String name) {
        Role find = findOneRole(id);
        find.setName(name);
        return roleRepository.save(find);
    }

    public String deleteRole(Integer id) {
        roleRepository.deleteById(id);
        return "Role with id : "+String.valueOf(id)+" is delete !";
    }
}
