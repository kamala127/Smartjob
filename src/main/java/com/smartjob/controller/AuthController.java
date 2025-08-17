package com.smartjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.dto.CreateUserDto;
import com.smartjob.entity.Users;
import com.smartjob.repository.UsersRepo;
import com.smartjob.service.UserService;
import com.smartjob.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private UserService userService;
	@Autowired
	private UsersRepo usersRepo;
    private  PasswordEncoder passwordEncoder;
    private  JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/create-user")
	public ResponseEntity<String> createUser(@RequestBody CreateUserDto createuserDto){
		ResponseEntity<String> response = userService.createUser(createuserDto);
		
		return response;
	}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CreateUserDto dto) {
        // findByUsername returns Optional<Users>
        return usersRepo.findByUsername(dto.getUsername())
                .map(user -> {
                    // Check password
                    if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                        String token = jwtUtil.generateToken(user.getUsername());
                        return ResponseEntity.ok(token);
                    } else {
                        return ResponseEntity.status(401).body("Invalid credentials");
                    }
                })
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid credentials"));
    }

    @GetMapping("/getall")
	public List<Users> getall(){
		return usersRepo.findAll();
		
	}
}
