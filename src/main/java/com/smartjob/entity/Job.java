package com.smartjob.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
public class Job {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String title;

	    @Column(length = 2000)
	    private String description;

	    private String location;
	    private Double salary;
	    private String jobType; // FULL_TIME, PART_TIME, INTERN, REMOTE

	    @ManyToOne
	    @JoinColumn(name = "recruiter_id", nullable = false)
	    private Users recruiter; // Recruiter who posted this job

	    private LocalDateTime postedAt;
	    private LocalDateTime updatedAt;

	    @PrePersist
	    public void onCreate() { 
	    	this.postedAt = LocalDateTime.now();
	    	
	    }

	    @PreUpdate
	    public void onUpdate() { 
	    	this.updatedAt = LocalDateTime.now();
	    	
	    }

	

}
