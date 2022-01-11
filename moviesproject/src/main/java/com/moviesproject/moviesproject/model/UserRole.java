package com.moviesproject.moviesproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="UserRole")
@NoArgsConstructor
@Data
public class UserRole {

     @Id()
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="userRoleId",insertable = false,updatable = false)
     private Integer userRoleId;

     @ManyToOne
     @JoinColumn(name="roleId")
     private Role role;

     @ManyToOne
     @JoinColumn(name="userId")
    private User user;


}
