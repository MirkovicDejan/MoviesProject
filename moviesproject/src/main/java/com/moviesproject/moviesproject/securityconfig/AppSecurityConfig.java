package com.moviesproject.moviesproject.securityconfig;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                //authorize UserRole endpoints
                .antMatchers("/find-one-user-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/create-user-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/delete-user-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/update-user-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/find-all-user-role").hasAnyRole(RolePremission.ADMIN.getPremission(), RolePremission.USER.getPremission()
                        , RolePremission.SUPER_USER.getPremission(), RolePremission.GUEST.getPremission())
                //authorize User endpoints
                .antMatchers("/find-one").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/save-user").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/delete-mapping").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/update-user").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/all-users").hasAnyRole(RolePremission.ADMIN.getPremission(), RolePremission.USER.getPremission()
                        , RolePremission.SUPER_USER.getPremission(), RolePremission.GUEST.getPremission())
                //authorize Role endpoints
                .antMatchers("/save-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/find-one-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/update-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/delete-role").hasRole(RolePremission.ADMIN.getPremission())
                .antMatchers("/get-all-role").hasAnyRole(RolePremission.ADMIN.getPremission(), RolePremission.USER.getPremission()
                        , RolePremission.SUPER_USER.getPremission(), RolePremission.GUEST.getPremission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        return daoAuthenticationProvider;
    }
}

