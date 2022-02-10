package com.moviesproject.moviesproject.security;

import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppSecurityService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        String passEncoded = user.getPassword();
        bCryptPasswordEncoder.encode(passEncoded);
        user.setPassword(passEncoded);
        return user;
    }
}
