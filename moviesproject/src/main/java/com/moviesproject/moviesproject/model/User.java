package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="User")
@NoArgsConstructor
@Data
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="userId")
    private Integer userId;

    @Column(name="userName",length = 20)
    private String userName;

    @Column(name="firstName",length = 20)
    private String firstName;

    @Column(name="lastName",length = 20)
    private String lastName;

    @Column(name="adress",length = 20)
    private String adress;

    @Column(name="phoneNumber",length = 20)
    private String phoneNumber;

    @Column(name="email",length = 50)
    private String email;

    @Column(name="password",length = 255)
    private String password;

    public User(String userName, String firstName, String lastName, String adress, String phoneNumber, String email,String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }


}
