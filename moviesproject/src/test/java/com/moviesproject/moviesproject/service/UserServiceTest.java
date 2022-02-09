package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.repository.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceTest {

    @Autowired
    private UserRepository repository;

    @Test
    void saveUser() {
        //get size of database before save
        int sizeBeforeSave = repository.findAll().size();
        //create some user for example, doesn't meter values !
        User user = new User();
        user.setUserName("User name");
        user.setFirstName("First name");
        user.setLastName("Last name");
        user.setPassword("Password");
        user.setPhoneNumber("Phone number");
        user.setEmail("E-mail");
        user.setAdress("adress");
        //save user and get values of saved user
        User save = repository.save(user);
        //get size after save
        int sizeAfterSave = repository.findAll().size();
        //check
        assertThat(save).isNotNull();
        assertThat(save).isEqualTo(user);
        assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    void all() {
        int finalSize = 100;
        Integer size = repository.findAll().size();
        assertThat(size).isNotZero();
        assertThat(size).isNotNegative();
        assertThat(size).isNotEqualTo(finalSize);
        assertThat(size).isLessThan(finalSize);
    }

    @Test
    void one() {
        Integer id = 2;
        User find = repository.findById(id).get();
        assertThat(find).isNotNull();
        assertThat(find.getUserId()).isEqualTo(id);
        assertThat(find).isExactlyInstanceOf(User.class);
        assertThat(find.getUserName()).isEqualTo("U1");
        assertThat(find.getFirstName()).isEqualTo("First1");
        assertThat(find.getLastName()).isEqualTo("Last1");
        assertThat(find.getAdress()).isEqualTo("ulica1");
        assertThat(find.getPhoneNumber()).isEqualTo("tel broj1");
        assertThat(find.getEmail()).isEqualTo("user@1");
        assertThat(find.getPassword()).isEqualTo("sifra1");
    }

    @Test
    void delete() {
        repository.deleteById(5);
        assertThat(repository.count()).isEqualTo(4L);
    }

    @Test
    void update() {
        //Data's for example, doesn't meters values
        Integer userId = 2;
        String userNameForUpdate = "Example";
        //when
        User userForUpdate = repository.findById(4).get();
        assertThat(userForUpdate.getUserName()).isNotEqualTo(userNameForUpdate);
        //then
        userForUpdate.setUserId(userId);
        userForUpdate.setUserName(userNameForUpdate);
        User check = repository.save(userForUpdate);
        assertThat(check.getUserName()).isEqualTo(userNameForUpdate);
        assertThat(repository.count()).isEqualTo(5);
    }

    @Test
    void existsByUserName() {
        String userName = "U2";
        boolean checkUserName = repository.existsByUserName(userName);
        assertThat(checkUserName).isNotNull();
        assertThat(checkUserName).isTrue();
    }

    @Test
    void existsByEmail() {
        String email = "user@2";
        boolean checkEmail = repository.existsByEmail(email);
        assertThat(checkEmail).isNotNull();
        assertThat(checkEmail).isTrue();
    }

    @Test
    void existsByPassword() {
        String password = "sifra2";
        boolean checkPassword = repository.existsByPassword(password);
        assertThat(password).isNotNull();
        assertThat(checkPassword).isTrue();
    }

    @Test
    void existsByPhoneNumber() {
        String phoneNumber = "tel broj2";
        boolean checkPhoneNumber = repository.existsByPhoneNumber(phoneNumber);
        assertThat(checkPhoneNumber).isNotNull();
        assertThat(checkPhoneNumber).isTrue();
    }
}
