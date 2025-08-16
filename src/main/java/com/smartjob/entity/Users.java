package com.smartjob.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(
	    name = "users",
	    indexes = {
	        @Index(name = "idx_username", columnList = "username"),
	        @Index(name = "idx_email", columnList = "email")
	    }
	)
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	private String password;
	private String fullName;
	private String phoneNumber;
	private String profilePicture;
	private String bio;
	private boolean active;
	private boolean verified;
	private String resumeUrl;
	private String experienceLevel;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@Enumerated(EnumType.STRING)
    private Role role; // CANDIDATE, RECRUITER, ADMIN
	
	@PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
	
	

}
