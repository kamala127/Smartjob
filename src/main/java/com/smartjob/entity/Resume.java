package com.smartjob.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Users candidate;

    private String resumeUrl; // AWS S3 link
    private String skills;
    private String experience;
    private String education;

    private LocalDateTime uploadedAt;

    @PrePersist
    public void onCreate() { 
    	this.uploadedAt = LocalDateTime.now(); 
    	
    }
}

