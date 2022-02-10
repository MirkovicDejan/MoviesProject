package com.moviesproject.moviesproject.dto;

import com.moviesproject.moviesproject.model.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class DTOUser {
    private String userName;
    private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String email;
    private String password;

    private static DTOUser instance;

    public static DTOUser getInstanceDtoUser(){
        if(instance == null){
            instance = new DTOUser();
        }
        return instance;
    }

    public DTOUser entityUserToDTO(User user) {
        DTOUser dtoUser = new DTOUser();
        dtoUser.setUserName(user.getUsername());
        dtoUser.setFirstName(user.getFirstName());
        dtoUser.setLastName(user.getLastName());
        dtoUser.setAdress(user.getAdress());
        dtoUser.setPhoneNumber(user.getPhoneNumber());
        dtoUser.setEmail(user.getEmail());
        dtoUser.setPassword(user.getPassword());
        return dtoUser;
    }

    public User DTOUserToEntityUser(DTOUser dtoUser) {
        User user = new User();
        user.setUserName(dtoUser.getUserName());
        user.setFirstName(dtoUser.getFirstName());
        user.setLastName(dtoUser.getLastName());
        user.setAdress(dtoUser.getAdress());
        user.setPhoneNumber(dtoUser.getPhoneNumber());
        user.setEmail(dtoUser.getEmail());
        user.setPassword(dtoUser.getPassword());
        return user;

    }

    public List<DTOUser> listEntityToDto(List<User>userList) {
        return userList.stream().map(x -> entityUserToDTO(x)).collect(Collectors.toList());
    }


}
