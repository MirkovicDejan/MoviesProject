package com.moviesproject.moviesproject.repository;

import MyQueries.MyQueryForRoleRepository;
import com.moviesproject.moviesproject.model.Role;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class RoleRepositoryTest {

    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void existsByName() {
        String name = "USER";
        MyQueryForRoleRepository qRole = new MyQueryForRoleRepository();
        String queryString = qRole.createQueryForExistsByName(name);
        Query query = entityManager.getEntityManager().createQuery(queryString);
        query.setParameter("name",name);
        String r = (String) query.getSingleResult();
        assertThat(r).isNotNull();
        assertThat(r).isEqualTo(name);
        System.out.println(r.toString());

    }
}