package com.smartjob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smartjob.dto.CreateUserDto;
import com.smartjob.dto.ResponseUserDto;
import com.smartjob.entity.Users;
import com.smartjob.repository.UsersRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UsersRepo userRepo;
	
	@Autowired
	private ResponseUserDto responseuserDto;

	
	public ResponseEntity<String> createUser(CreateUserDto createuserDto) {
		
		if(userRepo.existsByUsername(createuserDto.getUsername())) {
			throw new RuntimeException("Username already taken!");
	    }
		if(userRepo.existsByEmail(createuserDto.getEmail())) {
			throw new RuntimeException("Email already taken!");
		}
		
		Users u = new Users();
		u.setUsername(createuserDto.getUsername());
		u.setFullName(createuserDto.getFullName());
		u.setEmail(createuserDto.getEmail());
		u.setPassword(createuserDto.getPassword());
		u.setBio(createuserDto.getBio());
		u.setPhoneNumber(createuserDto.getPhoneNumber());
		
		userRepo.save(u);
		
		return new ResponseEntity<String>("User Created !",HttpStatus.CREATED);
	
	}
	
	
	public ResponseUserDto viewUser(Long userid) {
		Users u = userRepo.findById(userid)
	            .orElseThrow(() -> new RuntimeException("User not found with id " + userid));

	    ResponseUserDto responseUserDto = new ResponseUserDto();
	    responseUserDto.setUsername(u.getUsername());
	    responseUserDto.setActive(u.isActive());
	    responseUserDto.setBio(u.getBio());
	    responseUserDto.setEmail(u.getEmail());
	    responseUserDto.setFullName(u.getFullName());
	    responseUserDto.setPhoneNumber(u.getPhoneNumber());

	    return responseUserDto;
		
	}
	
	
	

}
