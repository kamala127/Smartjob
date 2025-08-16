package com.smartjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.dto.CreateUserDto;
import com.smartjob.dto.ResponseUserDto;
import com.smartjob.entity.Users;
import com.smartjob.repository.UsersRepo;
import com.smartjob.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CreateUserDto createuserDto;
	
	@Autowired
	private UsersRepo usersRepo;
	
	
	@PostMapping("/create-user")
	public ResponseEntity<String> createUser(@RequestBody CreateUserDto createuserDto){
		
		ResponseEntity<String> response = userService.createUser(createuserDto);
		
		return response;
	}
	
	@GetMapping("/getuser/{id}")
	public ResponseUserDto getuserbyId(@PathVariable("id") Long id) {
		return userService.viewUser(id);
	}
	
	@GetMapping("/getall")
	public List<Users> getall(){
		return usersRepo.findAll();
		
	}
	
}
