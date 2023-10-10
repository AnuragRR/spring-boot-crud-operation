package com.spring.springbootcrudoperation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootcrudoperation.dto.User;
import com.spring.springbootcrudoperation.exception.IdNotFoundException;
import com.spring.springbootcrudoperation.response.ResponseStructure;
import com.spring.springbootcrudoperation.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/getTodaysDate")
	public String getData() {
		return "Todays Date" + LocalDate.now();
	}

	@GetMapping(value = "/addition/{a}/{b}")
	public int addTwoNumber(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	@PostMapping(value = "/userData")
	public ResponseStructure<User> saveUserController(@RequestBody User user) {
		return service.saveUserService(user);
	}

	@GetMapping(value = "/getUserById/{userId}")
	public User getUserByIdController(@PathVariable int userId) {
		return service.getUserByIdService(userId);
	}

	@PostMapping(value = "/saveAllUser")
	public List<User> saveAllUserService(@RequestBody List<User> user) {
		return service.saveAllUserService(user);
	}

	@GetMapping(value = "/getAllUserData")
	public List<User> getAllUserDataDao() {
		return service.getAllUserDataService();
	}

	@PutMapping(value = "updateUserName/{userId}/{userName}")
	public User updateUserNameByIdController(@PathVariable int userId, @PathVariable String userName) {
		return service.updateUserNameByIdService(userId, userName);
	}

	@DeleteMapping(value = "/delete/{userId}")
	public ResponseStructure<User> deleteUserByUserIdController(@PathVariable int userId) throws IdNotFoundException {
		return service.deleteUserByUserIdService(userId);
	}

	@GetMapping(value = "/getUserByName/{userName}")
	public User findByUserNameController(@PathVariable String userName) {
		return service.findByUserNameServcie(userName);
	}

	@GetMapping(value = "/sortUserByName/{userName}")
	public List<User> sortUserByNameController(@PathVariable String userName) {
		return service.sortUserByNameService(userName);
	}

	@GetMapping(value = "/displayPageData/{pageNumber}/{pageDataSize}")
	public Page<User> displayDataByPassingPageNumberController(@PathVariable int pageNumber,@PathVariable int pageDataSize) {

		return service.displayDataByPassingPageNumberService(pageNumber,pageDataSize);
	}
	
	@GetMapping(value = "/getUserByEmail/{userEmail}")
	public User getUserByEmailController(@PathVariable String userEmail) {
		return service.getUserByEmailService(userEmail);
	}
}
