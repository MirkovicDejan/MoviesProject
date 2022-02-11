package com.moviesproject.moviesproject.service;
import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.exception.ApiRequestException;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(DTOUser dtoUser) {
        User convert = DTOUser.getInstanceDtoUser().DTOUserToEntityUser(dtoUser);
        if (userRepository.existsByUserName(convert.getUserName())) {
            throw new ApiRequestException("UserName ERROR !!! User with user name : " + convert.getUserName() + " exist in database !");
        } else if (userRepository.existsByEmail(convert.getEmail())) {
            throw new ApiRequestException("Email ERROR !!! User with email: " + convert.getEmail() + " exist in database !");
        } else if (userRepository.existsByPassword(convert.getPassword())) {
            throw new ApiRequestException("Password ERROR !!! User with password: " + convert.getPassword() + " exist in database !");
        } else if (userRepository.existsByPhoneNumber(convert.getPhoneNumber())) {
            throw new ApiRequestException("PhoneNumber ERROR !!! User with phone number :  " + convert.getPhoneNumber() + " exist in database !");
        } else {
            return userRepository.save(convert);
        }
    }

    public List<DTOUser> all() {
        List<User> findAll = userRepository.findAll();
        if (findAll.isEmpty()) {
            throw new ApiRequestException("Database is empty !");
        } else {
            return DTOUser.getInstanceDtoUser().listEntityToDto(findAll);
        }
    }

    public DTOUser one(Integer id) {
        if (userRepository.existsById(id)) {
            return DTOUser.getInstanceDtoUser().entityUserToDTO(userRepository.findById(id).get());
        } else {
            throw new ApiRequestException("User with id : " + id + " don't exists in database !");
        }
    }

    public void delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ApiRequestException("User with id : " + id + " don't exist in database !");
        }
    }

    public DTOUser update(Integer id, DTOUser dtoUser) {
        User convertUpdate = DTOUser.getInstanceDtoUser().DTOUserToEntityUser(dtoUser);
        if (userRepository.existsById(id)) {
            if (userRepository.existsByUserName(convertUpdate.getUserName())) {
                throw new ApiRequestException("Name : " + convertUpdate.getUserName() + " is in use for another User, please insert another !");
            } else if (userRepository.existsByEmail(convertUpdate.getEmail())) {
                throw new ApiRequestException("E-mail : " + convertUpdate.getEmail() + " is in use for another User, please insert another !");
            } else if (userRepository.existsByPhoneNumber(convertUpdate.getPhoneNumber())) {
                throw new ApiRequestException("Phone number : " + convertUpdate.getPhoneNumber() + " is in use for another User, please insert another !");
            } else if (userRepository.existsByPassword(convertUpdate.getPassword())) {
                throw new ApiRequestException("Password : " + convertUpdate.getPassword() + " is in use for another User, please insert another !");
            } else {
                convertUpdate.setUserId(id);
                return DTOUser.getInstanceDtoUser().entityUserToDTO(userRepository.save(convertUpdate));
            }
        } else {
            throw new ApiRequestException("UPDATE FOR THIS USER IS IMPOSSIBLE ! BECAUSE USER WITH ID : " + id + " DON'T EXISTS IN DATABASE !");
        }
    }
}




