package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.User;
import lombok.Data;

@Data
public class DTOUser {

    private String userName;
    private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private String password;

    public User createUser(){

        User user = new User();
        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAdress(adress);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }



}
