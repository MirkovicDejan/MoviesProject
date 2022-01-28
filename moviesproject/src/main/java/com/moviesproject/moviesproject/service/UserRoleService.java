package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.repository.RoleRepository;
import com.moviesproject.moviesproject.repository.UserRepository;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserRole create(Integer roleId, Integer userId) throws Exception {
        if (roleRepository.existsById(roleId) && userRepository.existsById(userId)) {
            Role r = roleRepository.findById(roleId).get();
            User u = userRepository.findById(userId).get();
            UserRole userRole = new UserRole();
            userRole.setUser(u);
            userRole.setRole(r);
            if (!userRoleRepository.existsByUser(userRole.getUser())) {
                return userRoleRepository.save(userRole);
            }
            throw new Exception(u.toString() + "in user role database exist please insert another user with difrent values!");
        }
        throw new Exception("Id for role : " + roleId + ", and id for user : " + userId + " don't exist in database !");
    }

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public UserRole findOneUserRole(Integer id) throws Exception {
        if (userRoleRepository.existsById(id)) {
            return userRoleRepository.findById(id).get();
        }
        throw new Exception("UserRole with : " + id + "don't exist in database !");
    }

    public String delete(Integer id) throws Exception {
        if (userRoleRepository.existsById(id)) {
            userRoleRepository.deleteById(id);
            return "User role with id : " + id + " is delete !";
        }
        return ("Selected UserRole with id : " + id + " don't exist !");
    }

    public UserRole updateUserRole(Integer userRoleId, Integer roleId, Integer userId) throws Exception {
        if (userRoleRepository.existsById(userRoleId) && userRepository.existsById(userId) && roleRepository.existsById(roleId)) {
            UserRole userRoleUpdate = userRoleRepository.findById(userRoleId).get();
            User uUpdate = userRepository.findById(userId).get();
            Role roleUpdate = roleRepository.findById(roleId).get();
            userRoleUpdate.setUserRoleId(userRoleId);
            userRoleUpdate.setUser(uUpdate);
            userRoleUpdate.setRole(roleUpdate);
            return userRoleRepository.save(userRoleUpdate);
        }
        throw new Exception("User Role or User or Role don't exist in database !");
    }
}




