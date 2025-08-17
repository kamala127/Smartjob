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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getResumeUrl() {
		return resumeUrl;
	}

	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	public String getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", profilePicture=" + profilePicture
				+ ", bio=" + bio + ", active=" + active + ", verified=" + verified + ", resumeUrl=" + resumeUrl
				+ ", experienceLevel=" + experienceLevel + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", role=" + role + "]";
	}

	public Users(Long id, String username, String email, String password, String fullName, String phoneNumber,
			String profilePicture, String bio, boolean active, boolean verified, String resumeUrl,
			String experienceLevel, LocalDateTime createdAt, LocalDateTime updatedAt, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.profilePicture = profilePicture;
		this.bio = bio;
		this.active = active;
		this.verified = verified;
		this.resumeUrl = resumeUrl;
		this.experienceLevel = experienceLevel;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.role = role;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
