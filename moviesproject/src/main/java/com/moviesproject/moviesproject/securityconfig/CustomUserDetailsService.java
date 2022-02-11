package com.moviesproject.moviesproject.securityconfig;


import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import com.moviesproject.moviesproject.repository.UserRepository;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private   UserRoleRepository userRoleRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        UserRole ur = userRoleRepository.findByUser(user);
        UserDetails userRola = org.springframework.security.core.userdetails.User
                .builder()
                .username(ur.getUser().getUserName())
                .password(passwordEncoder.encode(ur.getUser().getPassword()))
                .roles(ur.getRole().getName())
                .build();
        return userRola;
    }
}
