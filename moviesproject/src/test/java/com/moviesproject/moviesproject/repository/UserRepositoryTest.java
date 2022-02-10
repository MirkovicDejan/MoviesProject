package com.moviesproject.moviesproject.repository;

import MyQueries.MyQUERIES;
import com.moviesproject.moviesproject.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.*;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void save() {
        Query query = entityManager.getEntityManager().createQuery("SELECT count(userId) from User");
        Long sizeBeforeSave = (Long) query.getSingleResult();
        assertThat(sizeBeforeSave).isNotNull();
        assertThat(sizeBeforeSave).isEqualTo(5L);
        User user = new User();
        user.setUserName("User name");
        user.setFirstName("First name");
        user.setLastName("Last name");
        user.setPassword("Password");
        user.setPhoneNumber("Phone number");
        user.setEmail("E-mail");
        user.setAdress("adress");
        assertThat(user).isNotNull();
        assertThat(user).isExactlyInstanceOf(User.class);
        entityManager.persistAndFlush(user);
        Query query2 = entityManager.getEntityManager().createQuery("SELECT count(userId) from User");
        Long sizeAfterSave = (Long) query2.getSingleResult();
        assertThat(sizeAfterSave).isNotNull();
        assertThat(sizeAfterSave).isEqualTo(6L);
        assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    void update(){
        Integer userId = 3;
        String userNameUpdate = "UPDATE";
        Query query = entityManager.getEntityManager().createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        query.setParameter("userId",userId);
        User userForUpdate = (User) query.getSingleResult();
        assertThat(userForUpdate).isNotNull();
        assertThat(userForUpdate).isExactlyInstanceOf(User.class);
        userForUpdate.setUserId(userId);
        userForUpdate.setUserName(userNameUpdate);
        entityManager.persistAndFlush(userForUpdate);
        Query query2 = entityManager.getEntityManager().createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        query2.setParameter("userId",userId);
        User afterUpdate = (User) query2.getSingleResult();
        assertThat(afterUpdate).isNotNull();
        assertThat(afterUpdate).isExactlyInstanceOf(User.class);
        assertThat(afterUpdate.getUsername()).isEqualTo(userNameUpdate);
        System.out.println(afterUpdate.getUsername());
    }

    @Test
    void find(){
        Query query = entityManager.getEntityManager().createQuery("SELECT u FROM User u");
        List<User> list = query.getResultList();
        User user = new User();
        user.setUserId(1);
        user.setUserName("U");
        user.setFirstName("First");
        user.setLastName("Last");
        user.setPassword("ulica");
        user.setPhoneNumber("tel broj");
        user.setEmail("user@");
        user.setAdress("sifra");
        assertThat(list).size().isNotNegative();
        assertThat(list).isNotEmpty();
        assertThat(list.contains(user));
        assertThat(list).size().isEqualTo(5);
    }

    @Test
    void delete(){
        Integer userId = 5;
        Query query = entityManager.getEntityManager().createQuery("delete from User u where u.userId = :userId");
        int delete = query.setParameter("userId",userId).executeUpdate();
        Query query1 = entityManager.getEntityManager().createQuery("SELECT count(userId) from User");
        Long sizeAfterDelete = (Long) query1.getSingleResult();
        assertThat(sizeAfterDelete).isNotNull();
        assertThat(sizeAfterDelete).isEqualTo(4L);
    }

    @Test
    void findOne(){
        Integer userId = 5;
        Query query = entityManager.getEntityManager().createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        query.setParameter("userId",userId);
        User findOne = (User) query.getSingleResult();
        assertThat(findOne).isNotNull();
        assertThat(findOne).isExactlyInstanceOf(User.class);
        assertThat(findOne.getUserId()).isEqualTo(userId);
        System.out.println(findOne);
    }

    @Test
    void existsByUserName() {
        String userName = "U3";
        Query query = entityManager.getEntityManager().createQuery(MyQUERIES.EXIST_BY_USERNAME.getQuery());
        query.setParameter("userName", userName);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(userName);
        System.out.println(list.toString());
    }

    @Test
    void existsByEmail() {
        String email = "user@3";
        Query query = entityManager.getEntityManager().createQuery(MyQUERIES.EXIST_BY_EMAIL.getQuery());
        query.setParameter("email", email);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(email);
        System.out.println(list.toString());
    }

    @Test
    void existsByPassword() {
        String password = "sifra3";
        Query query = entityManager.getEntityManager().createQuery(MyQUERIES.EXIST_BY_PASSWORD.getQuery());
        query.setParameter("password", password);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(password);
        System.out.println(list.toString());
    }

    @Test
    void existsByPhoneNumber() {
        String phoneNumber = "tel broj3";
        Query query = entityManager.getEntityManager().createQuery(MyQUERIES.EXIST_BY_PHONE_NUMBER.getQuery());
        query.setParameter("phoneNumber", phoneNumber);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(phoneNumber);
        System.out.println(list.toString());
    }

}

