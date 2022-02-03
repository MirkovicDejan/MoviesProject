package com.moviesproject.moviesproject.repository;

import MyQueries.MyQueryForUserRepository;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void existsByUserName() {
        String userName = "U3";
        MyQueryForUserRepository q = new MyQueryForUserRepository();
        String queryString = q.createQueryForExistUserName(userName);
        Query query = entityManager.getEntityManager().createQuery(queryString);
        query.setParameter("userName", userName);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(userName);
        System.out.println(list.toString());
    }

    @Test
    void existsByEmail() {
        String email = "user@3";
        MyQueryForUserRepository myQuery = new MyQueryForUserRepository();
        String queryString = myQuery.createQueryForExistsByEmail(email);
        Query query = entityManager.getEntityManager().createQuery(queryString);
        query.setParameter("email", email);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(email);
        System.out.println(list.toString());
    }

    @Test
    void existsByPassword() {
        String password = "sifra3";
        MyQueryForUserRepository myQuery = new MyQueryForUserRepository();
        String queryString = myQuery.createQueryForExistsByPassword(password);
        Query query = entityManager.getEntityManager().createQuery(queryString);
        query.setParameter("password", password);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(password);
        System.out.println(list.toString());
    }

    @Test
    void existsByPhoneNumber() {
        String phoneNumber = "tel broj3";
        MyQueryForUserRepository myQuery = new MyQueryForUserRepository();
        String queryString = myQuery.createQueryForExistsByPhoneNumber(phoneNumber);
        Query query = entityManager.getEntityManager().createQuery(queryString);
        query.setParameter("phoneNumber", phoneNumber);
        List<String> list = query.getResultList();
        assertThat(list).isNotEmpty();
        assertThat(list).contains(phoneNumber);
        System.out.println(list.toString());
    }

}

