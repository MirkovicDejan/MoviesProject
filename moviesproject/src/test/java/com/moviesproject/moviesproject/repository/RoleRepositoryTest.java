package com.moviesproject.moviesproject.repository;

import com.moviesproject.moviesproject.model.Role;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class RoleRepositoryTest extends AbstractRepository {

	@Autowired
	private RoleRepository repository;

	@Test
	public void checkCount() {
		long count = repository.count();
		assertThat(count).isEqualTo(5L);
	}

	@Test
	public void findOne() {
		Role role = repository.getById(3);

		assertThat(role).isNotNull();
		assertThat(role.getRoleId()).isEqualTo(3);
		assertThat(role.getName()).isEqualTo("ADMIN");
	}

	@Test
	public void notFound() {
		Exception exception = Assertions.assertThrows(EntityNotFoundException.class, () -> {
			Role role = repository.getById(10);
			role.getName();
		});

		String expectedMessage = "Unable to find com.moviesproject.moviesproject.m*-odel.Role with id 10";
		String actualMessage = exception.getMessage();

		Assertions.assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void save() {
		long sizeBeforeSave = repository.count();

		String roleName = "SUPER_GUEST";

		Role role = new Role();
		role.setName(roleName);
		entityManager.persistAndFlush(role);

		// when
		Role found = repository.findByName(roleName);
		// then
		assertThat(found).isNotNull();
		assertThat(found.getName()).isEqualTo(role.getName());

		long sizeAfterSize = repository.count();
		assertThat(sizeAfterSize).isGreaterThan(sizeBeforeSave);
	}

	@Test
	public void update() {

		Integer roleId = 1;
		String roleNameUpdate = "GUEST_ROLE";

		Optional<Role> optionalRole = repository.findById(roleId);

		optionalRole.ifPresent(role -> {
			role.setName(roleNameUpdate);
			entityManager.persistAndFlush(role);

			Role found = repository.findByName(roleNameUpdate);

			assertThat(found.getRoleId()).isEqualTo(roleId);
			assertThat(found.getName()).isEqualTo(roleNameUpdate);
		});
	}

	@Test
	public void delete() {
		repository.deleteById(2);
		assertThat(repository.count()).isEqualTo(4);
	}

	@Test
	public void deleteNotExist() {
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(20);
		});
	}
}
