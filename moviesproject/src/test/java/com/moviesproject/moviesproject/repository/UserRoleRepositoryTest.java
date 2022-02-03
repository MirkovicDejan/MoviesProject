package com.moviesproject.moviesproject.repository;

import MyQueries.MyQueryForUserRoleRepository;
import com.moviesproject.moviesproject.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
class UserRoleRepositoryTest {
    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void existsByUser() {
      int id = 4;
      MyQueryForUserRoleRepository myQuery = new MyQueryForUserRoleRepository();
      String queryString = myQuery.queryForExistsByUser(id);
      Query query = entityManager.getEntityManager().createQuery(queryString);
      query.setParameter("id",id);
      User u = (User) query.getSingleResult();
      assertThat(u).isNotNull();
      assertThat(u.getUserId()).isEqualTo(id);
      System.out.println(u.toString());
    }
}