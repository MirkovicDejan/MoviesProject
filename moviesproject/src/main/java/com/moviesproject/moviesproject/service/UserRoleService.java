package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.exception.ApiRequestException;
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
        if (!roleRepository.existsById(roleId)) {
            throw new ApiRequestException("Role with id : " + roleId + " don't exists in database !");
        } else if (!userRepository.existsById(userId)) {
            throw new ApiRequestException("User with id : " + userId + " don't exists in database !");
        } else {
            Role r = roleRepository.findById(roleId).get();
            User u = userRepository.findById(userId).get();
            UserRole userRole = new UserRole();
            userRole.setUser(u);
            userRole.setRole(r);
            if (!userRoleRepository.existsByUser(userRole.getUser())) {
                return userRoleRepository.save(userRole);
            }
            throw new ApiRequestException(u + "in user role database exist please insert another user with different values!");
        }
    }

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public UserRole findOneUserRole(Integer id) throws Exception {
        if (userRoleRepository.existsById(id)) {
            return userRoleRepository.findById(id).get();
        }
        throw new ApiRequestException("UserRole with : " + id + "don't exist in database !");
    }

    public String delete(Integer id) throws Exception {
        if (userRoleRepository.existsById(id)) {
            userRoleRepository.deleteById(id);
            return "User role with id : " + id + " is delete !";
        }
        return ("Selected UserRole with id : " + id + " don't exist !");
    }

    public UserRole updateUserRole(Integer userRoleId, Integer roleId, Integer userId) {
        if (!userRoleRepository.existsById(userRoleId)) {
            throw new ApiRequestException("UserRole with id : " + userRoleId + " don't exists in database !");
        } else if (userRepository.existsById(userId)) {
            throw new ApiRequestException("User with id : " + userId + " don't exists in database user!");
        } else if (!roleRepository.existsById(roleId)) {
            throw new ApiRequestException("Role with id : " + roleId + " don't exists in database role");
        } else {
            UserRole userRoleUpdate = userRoleRepository.findById(userRoleId).get();
            User uUpdate = userRepository.findById(userId).get();
            Role roleUpdate = roleRepository.findById(roleId).get();
            userRoleUpdate.setUserRoleId(userRoleId);
            userRoleUpdate.setUser(uUpdate);
            userRoleUpdate.setRole(roleUpdate);
            return userRoleRepository.save(userRoleUpdate);
        }
    }
}




