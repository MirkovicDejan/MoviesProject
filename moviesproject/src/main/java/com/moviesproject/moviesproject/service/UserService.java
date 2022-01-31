package com.moviesproject.moviesproject.service;

<<<<<<< HEAD
import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.exception.ApiExceptionHandler;
import com.moviesproject.moviesproject.exception.ApiRequestException;
=======
import com.moviesproject.moviesproject.exception.UserNotFoundException;
>>>>>>> origin/junitbrnach
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
<<<<<<< HEAD
    public User saveUser(DTOUser dtoUser) {
        User convert = dtoUser.DTOUserToEntityUser(dtoUser);
       if(userRepository.existsByUserName(convert.getUserName())){
           throw new ApiRequestException("UserName ERROR !!! User with user name : "+convert.getUserName()+" exist in database !");
          }else if(userRepository.existsByEmail(convert.getEmail())){
           throw new ApiRequestException("Email ERROR !!! User with email: "+convert.getEmail()+" exist in database !");
          }else if(userRepository.existsByPassword(convert.getPassword())){
           throw new ApiRequestException("Password ERROR !!! User with password: "+convert.getPassword()+" exist in database !");
          }else if (userRepository.existsByPhoneNumber(convert.getPhoneNumber())){
              throw new ApiRequestException("PhoneNumber ERROR !!! User with phone number :  " + convert.getPhoneNumber()+" exist in database !");
          }else {
           return userRepository.save(convert);
       }
=======


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //nije dobro
    public User findOneUsre(Integer id) {
        Optional<User> findOne = userRepository.findById(id);
        if (findOne.isPresent()) {
            return findOne.get();
        }
            return null;
    }
    /*
    public UserDTO findOneUser(Integer id) {
        User userEntity = this.userRepository.findById(id).orElseThrow(() -> {
            final String errorMessage = "The user with id = " + id + " not found.";
            UserNotFoundException userNotFoundException = new UserNotFoundException(errorMessage);
            log.error(errorMessage, userNotFoundException);
            return userNotFoundException;
        });
        return UserService.convertToUserDTO(userEntity);
    }*/

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    //public User updateUser(User user) {
    //public UserDTO updateUser(UserDTO userDto) {
    // ovo ti nije dobro, trebalo bi biti jedno od ovog gore
    public User updateUser(Integer id, String userName, String firstName, String lastname, String adress, String phoneNumber, String email, String password) {
        User findUserForUpdate = findOneUsre(id);
        findUserForUpdate.setUserName(userName);
        findUserForUpdate.setFirstName(firstName);
        findUserForUpdate.setLastName(lastname);
        findUserForUpdate.setAdress(adress);
        findUserForUpdate.setPhoneNumber(phoneNumber);
        findUserForUpdate.setEmail(email);
        findUserForUpdate.setPassword(password);
        return userRepository.save(findUserForUpdate);

    }

    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "User with id : " + String.valueOf(id) + " is delete !";
>>>>>>> origin/junitbrnach
    }
}

  
