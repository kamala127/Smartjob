package com.smartjob.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;
@Data
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Users candidate;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private String resumeUrl; // AWS S3 Link

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status; // APPLIED, SHORTLISTED, REJECTED, HIRED

    private LocalDateTime appliedAt;

    @PrePersist
    public void onCreate() { 
    	
    	this.appliedAt = LocalDateTime.now();
    	
    }
}

