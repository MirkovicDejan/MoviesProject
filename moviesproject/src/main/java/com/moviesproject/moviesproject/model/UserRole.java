package com.moviesproject.moviesproject.model;

import com.moviesproject.moviesproject.security.RolePremission;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "UserRole")
@Data
@EqualsAndHashCode
public class UserRole {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userRoleId")
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private RolePremission rolePremission;

    public UserRole() {

    }

    public UserRole(Role role1, User user1) {
        this.role = role1;
        this.user = user1;
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
