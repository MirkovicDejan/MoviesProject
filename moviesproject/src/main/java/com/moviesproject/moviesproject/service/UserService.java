package com.moviesproject.moviesproject.service;
import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.exception.ApiRequestException;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
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
}


