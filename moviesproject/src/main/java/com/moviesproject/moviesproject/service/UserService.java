package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.exception.ApiRequestException;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
        User convert = dtoUser.DTOUserToEntityUser(dtoUser);
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
}



