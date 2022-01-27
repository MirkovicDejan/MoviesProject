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

    public UserRole updateUserRole(Integer idUserRole, String userName, String firstName, String lastName, String adress, String phoneNumber, String password, String email, String nameForRole) throws Exception {
        if (userRoleRepository.existsById(idUserRole)) {
            UserRole userRoleForUpdate = userRoleRepository.findById(idUserRole).get();
            userRoleForUpdate.getUser().setUserName(userName);
            userRoleForUpdate.getUser().setFirstName(firstName);
            userRoleForUpdate.getUser().setLastName(lastName);
            userRoleForUpdate.getUser().setAdress(adress);
            userRoleForUpdate.getUser().setPhoneNumber(phoneNumber);
            userRoleForUpdate.getUser().setPassword(password);
            userRoleForUpdate.getUser().setEmail(email);
            userRoleForUpdate.getRole().setName(nameForRole);
            
            return userRoleRepository.save(userRoleForUpdate);
        }
        throw new Exception("UserRole with id : " + idUserRole + " don't exist in database !");
    }
}



