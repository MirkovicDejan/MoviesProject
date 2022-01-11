package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findOneUsre(Integer id) {
        Optional<User> findOne = userRepository.findById(id);
        if (findOne.isPresent()) {
            return findOne.get();
        }
            return null;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

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
    }
}
