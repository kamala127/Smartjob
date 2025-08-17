package com.smartjob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartjob.config.SecurityConfig;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	
	public ResponseEntity<String> createUser(CreateUserDto createuserDto) {	
		
		ResponseEntity<String> response = userDataexist(createuserDto.getUsername(),createuserDto.getEmail());
		
		if (response.getStatusCode() == HttpStatus.OK) {
			Users u = new Users();
			u.setUsername(createuserDto.getUsername());
			u.setFullName(createuserDto.getFullName());
			u.setEmail(createuserDto.getEmail());
			u.setPassword(passwordEncoder.encode(createuserDto.getPassword()));
			u.setBio(createuserDto.getBio());
			u.setPhoneNumber(createuserDto.getPhoneNumber());
			u.setActive(true);
			u.setRole(createuserDto.getRole());
			userRepo.save(u);
			
			return new ResponseEntity<String>("User Created !",HttpStatus.CREATED);
		}else {
			return response;
		}
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
	    responseUserDto.setRole(u.getRole());
	    return responseUserDto;
		
	}
	
	public ResponseEntity<String> userDataexist(String name, String email) {
		
		if(userRepo.existsByUsername(name)) {
			return new ResponseEntity<String>("Username is already exist Please provide unique!",HttpStatus.CONFLICT);
		}else if(userRepo.existsByEmail(email)) {
			return new ResponseEntity<String>("Email is already exist Please provide unique!",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("Great !",HttpStatus.OK);
	}
	
	

}
