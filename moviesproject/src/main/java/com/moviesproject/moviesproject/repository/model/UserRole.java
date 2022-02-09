package com.moviesproject.moviesproject.repository.model;

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
     @Column(name="userRoleId")
     private Integer userRoleId;

     @ManyToOne
     @JoinColumn(name="roleId")
     private Role role;

     @ManyToOne
     @JoinColumn(name="userId")
     private User user;

     public UserRole(Role role1,User user1){
            this.role=role1;
            this.user=user1;
     }

     @Override
     public String toString() {
          return "UserRole{" +
                  "userRoleId=" + userRoleId +
                  ", role=" + role +
                  ", user=" + user +
                  '}';
     }
}