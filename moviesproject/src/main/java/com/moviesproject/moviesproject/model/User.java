package com.moviesproject.moviesproject.model;

import com.moviesproject.moviesproject.security.RolePremission;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="User")
@Data
@EqualsAndHashCode
public class User implements UserDetails {
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

    @Enumerated(EnumType.STRING)
    private RolePremission rolePremission;


    public User(){

    }

    public User(String userName, String firstName, String lastName, String adress, String phoneNumber, String email,String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(rolePremission.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
