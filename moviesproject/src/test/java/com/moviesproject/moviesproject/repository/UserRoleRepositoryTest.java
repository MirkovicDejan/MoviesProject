package com.moviesproject.moviesproject.repository;

import MyQueries.MyQUERIES;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.model.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Query;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRoleRepositoryTest {
    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void save() {
        // Because UserRole entity is entity of two entity first user and second role ! We need first that's object's User and Role!
        Integer roleId = 3;
        Integer userId = 2;
        //Get and check size of database before save.
        Query queryCount = entityManager.getEntityManager().createQuery("SELECT count(userRoleId) from UserRole");
        Long sizeBeforeSave = (Long) queryCount.getSingleResult();
        Assertions.assertThat(sizeBeforeSave).isNotNull();
        Assertions.assertThat(sizeBeforeSave).isEqualTo(4L);
        //Get and check User
        Query queryUser = entityManager.getEntityManager().createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        queryUser.setParameter("userId",userId);
        User user = (User) queryUser.getSingleResult();
        assertThat(user).isNotNull();
        assertThat(user).isExactlyInstanceOf(User.class);
        assertThat(user.getUserId()).isEqualTo(userId);
        //Get and check Role
        Query roleQuery = entityManager.getEntityManager().createQuery("SELECT r FROM Role r WHERE r.roleId = :roleId");
        roleQuery.setParameter("roleId",roleId);
        Role role = (Role) roleQuery.getSingleResult();
        assertThat(role).isNotNull();
        assertThat(role.getRoleId()).isEqualTo(roleId);
        assertThat(role).isExactlyInstanceOf(Role.class);
        //Create instance of UserRole,set attributes, check, and save into database !
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        assertThat(userRole).isNotNull();
        assertThat(userRole).isExactlyInstanceOf(UserRole.class);
        System.out.println(userRole);
        entityManager.persistAndFlush(userRole);
        //Get size after save and check
        Query queryCount2 = entityManager.getEntityManager().createQuery("SELECT count(userRoleId) from UserRole");
        Long sizeAfterSave = (Long) queryCount2.getSingleResult();
        Assertions.assertThat(sizeAfterSave).isNotNull();
        Assertions.assertThat(sizeAfterSave).isEqualTo(5L);
        Assertions.assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    void update(){
        //Get UserRole Entity
        Integer userRoleId = 4;
        Query userRoleQuery = entityManager.getEntityManager().createQuery("SELECT ur FROM UserRole ur WHERE ur.userRoleId = :userRoleId");
        userRoleQuery.setParameter("userRoleId",userRoleId);
        UserRole userRole = (UserRole) userRoleQuery.getSingleResult();
        assertThat(userRole).isNotNull();
        assertThat(userRole).isExactlyInstanceOf(UserRole.class);
        assertThat(userRole.getUserRoleId()).isEqualTo(userRoleId);
        System.out.println("UserRole before update : "+userRole);
        //find new user and check
        Integer userId = 2;
        Query userQuery = entityManager.getEntityManager().createQuery("SELECT u FROM User u WHERE u.userId = :userId");
        userQuery.setParameter("userId",userId);
        User user = (User) userQuery.getSingleResult();
        assertThat(user).isNotNull();
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user).isExactlyInstanceOf(User.class);
        //update
        userRole.setUserRoleId(userRoleId);
        userRole.setUser(user);
        entityManager.persistAndFlush(userRole);
        //check
        Query checkUserRoleQuery = entityManager.getEntityManager().createQuery("SELECT ur FROM UserRole ur WHERE ur.userRoleId = :userRoleId");
        checkUserRoleQuery.setParameter("userRoleId",userRoleId);
        UserRole checkUpdate = (UserRole) checkUserRoleQuery.getSingleResult();
        assertThat(checkUpdate).isNotNull();
        assertThat(checkUpdate.getUserRoleId()).isEqualTo(userRoleId);
        assertThat(checkUpdate).isExactlyInstanceOf(UserRole.class);
        System.out.println("After update UserRole is : "+checkUpdate);
    }

    @Test
    void find(){
        Query query = entityManager.getEntityManager().createQuery("SELECT ur FROM UserRole ur");
        List<UserRole> list = query.getResultList();
        UserRole userRole = new UserRole();
        userRole.setUserRoleId(3);
        Assertions.assertThat(list).size().isNotNegative();
        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list.contains(userRole));
        Assertions.assertThat(list).size().isEqualTo(4);
    }

    @Test
    void delete(){
        Integer userRoleId = 4;
        Query query = entityManager.getEntityManager().createQuery("delete from UserRole ur where ur.userRoleId = :userRoleId");
        int delete = query.setParameter("userRoleId",userRoleId).executeUpdate();
        Query query1 = entityManager.getEntityManager().createQuery("SELECT count(userRoleId) from UserRole");
        Long sizeAfterDelete = (Long) query1.getSingleResult();
        assertThat(sizeAfterDelete).isNotNull();
        assertThat(sizeAfterDelete).isEqualTo(3L);
    }

    @Test
    void findOne(){
        Integer userRoleId = 4;
        Query query = entityManager.getEntityManager().createQuery("SELECT ur FROM UserRole ur WHERE ur.userRoleId = :userRoleId");
        query.setParameter("userRoleId",userRoleId);
        UserRole findOne = (UserRole) query.getSingleResult();
        assertThat(findOne).isNotNull();
        assertThat(findOne).isExactlyInstanceOf(UserRole.class);
        assertThat(findOne.getUserRoleId()).isEqualTo(userRoleId);
        assertThat(findOne.getRole().getName()).isEqualTo("ADMIN");
        assertThat(findOne.getUser().getUsername()).isEqualTo("U3");
        System.out.println(findOne);
    }

    @Test
    void existsByUser() {
      int id = 4;
      Query query = entityManager.getEntityManager().createQuery(MyQUERIES.EXISTS_BY_USER.getQuery());
      query.setParameter("id",id);
      User u = (User) query.getSingleResult();
      assertThat(u).isNotNull();
      assertThat(u.getUserId()).isEqualTo(id);
      assertThat(u).isExactlyInstanceOf(User.class);
      assertThat(u.getUsername()).isEqualTo("U3");
      System.out.println(u);
    }

}