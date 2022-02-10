package com.moviesproject.moviesproject.repository;

import MyQueries.MyQUERIES;
import com.moviesproject.moviesproject.model.Role;
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
class RoleRepositoryTest {

    @Autowired
    protected TestEntityManager entityManager;

    @Test
    void save() {
        Query query = entityManager.getEntityManager().createQuery("SELECT count(roleId) from Role");
        Long sizeBeforeSave = (Long) query.getSingleResult();
        Assertions.assertThat(sizeBeforeSave).isNotNull();
        Assertions.assertThat(sizeBeforeSave).isEqualTo(5L);
        Role role = new Role();
        role.setName("EXAMPLE_NAME");
        Assertions.assertThat(role).isNotNull();
        Assertions.assertThat(role).isExactlyInstanceOf(Role.class);
        entityManager.persistAndFlush(role);
        Query query2 = entityManager.getEntityManager().createQuery("SELECT count(roleId) from Role");
        Long sizeAfterSave = (Long) query2.getSingleResult();
        Assertions.assertThat(sizeAfterSave).isNotNull();
        Assertions.assertThat(sizeAfterSave).isEqualTo(6L);
        Assertions.assertThat(sizeAfterSave).isGreaterThan(sizeBeforeSave);
    }

    @Test
    void update(){
        Integer roleId = 3;
        String roleNameUpdate = "UPDATE";
        Query query = entityManager.getEntityManager().createQuery("SELECT r FROM Role r WHERE r.roleId = :roleId");
        query.setParameter("roleId",roleId);
        Role roleForUpdate = (Role) query.getSingleResult();
        Assertions.assertThat(roleForUpdate).isNotNull();
        Assertions.assertThat(roleForUpdate).isExactlyInstanceOf(Role.class);
        roleForUpdate.setRoleId(roleId);
        roleForUpdate.setName(roleNameUpdate);
        entityManager.persistAndFlush(roleForUpdate);
        Query query2 = entityManager.getEntityManager().createQuery("SELECT r FROM Role r WHERE r.roleId = :roleId");
        query2.setParameter("roleId",roleId);
        Role afterUpdate = (Role) query2.getSingleResult();
        Assertions.assertThat(afterUpdate).isNotNull();
        Assertions.assertThat(afterUpdate).isExactlyInstanceOf(Role.class);
        Assertions.assertThat(afterUpdate.getName()).isEqualTo(roleNameUpdate);
        System.out.println(afterUpdate.getName());
    }

    @Test
    void find(){
        Query query = entityManager.getEntityManager().createQuery("SELECT r FROM Role r");
        List<Role> list = query.getResultList();
        Role role = new Role();
        role.setRoleId(1);
        role.setName("TEST");
        Assertions.assertThat(list).size().isNotNegative();
        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list.contains(role));
        Assertions.assertThat(list).size().isEqualTo(5);
    }

    @Test
    void delete(){
        Integer roleId = 5;
        Query query = entityManager.getEntityManager().createQuery("delete from Role r where r.roleId = :roleId");
        int delete = query.setParameter("roleId",roleId).executeUpdate();
        Query query1 = entityManager.getEntityManager().createQuery("SELECT count(roleId) from Role");
        Long sizeAfterDelete = (Long) query1.getSingleResult();
        Assertions.assertThat(sizeAfterDelete).isNotNull();
        Assertions.assertThat(sizeAfterDelete).isEqualTo(4L);
    }

    @Test
    void findOne(){
        Integer roleId = 5;
        Query query = entityManager.getEntityManager().createQuery("SELECT r FROM Role r WHERE r.roleId = :roleId");
        query.setParameter("roleId",roleId);
        Role findOne = (Role) query.getSingleResult();
        Assertions.assertThat(findOne).isNotNull();
        Assertions.assertThat(findOne).isExactlyInstanceOf(Role.class);
        Assertions.assertThat(findOne.getRoleId()).isEqualTo(roleId);
        System.out.println(findOne);
    }

    @Test
    void existsByName() {
        String name = "USER";
        Query query = entityManager.getEntityManager().createQuery(MyQUERIES.EXIST_BY_NAME.getQuery());
        query.setParameter("name",name);
        String r = (String) query.getSingleResult();
        assertThat(r).isNotNull();
        assertThat(r).isEqualTo(name);
        System.out.println(r);

    }
}