package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/save-user")
	public User saveUser(@RequestBody DTOUser dtoUser) {
		return userService.saveUser(dtoUser.createUser());
	}

	@GetMapping("/find-one-user")
	public User findOneUser(@RequestParam Integer id) {
		return userService.findOneUsre(id);
	}

	@GetMapping({"/find-all-user", ""})
	public List<User> findAllUser() {
		return userService.findAllUser();
	}

	@PutMapping("/update-user")
	//public User updateUser(@RequestParam Integer id, @RequestBody UserDTO userDto)
	//nije dobro ovo, prevelik broj parametara, mozes rijesiti sa RequestBody
	public User updateUser(@RequestParam Integer id, @RequestParam String userName, @RequestParam String firstName, @RequestParam String lastname,
	                       @RequestParam String adress, @RequestParam String phoneNumber, @RequestParam String email, @RequestParam String password) {
		return userService.updateUser(id, userName, firstName, lastname, adress, phoneNumber, email, password);
		//return userService.updateUser(id, userDto);
	}

	@DeleteMapping("/delete-user")
	public String deleteUser(@RequestParam Integer id) {
		userService.deleteUser(id);
		return "User with id : " + String.valueOf(id) + " is delete !";
	}

}
