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

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public String getJobType() {
			return jobType;
		}

		public void setJobType(String jobType) {
			this.jobType = jobType;
		}

		public Users getRecruiter() {
			return recruiter;
		}

		public void setRecruiter(Users recruiter) {
			this.recruiter = recruiter;
		}

		public LocalDateTime getPostedAt() {
			return postedAt;
		}

		public void setPostedAt(LocalDateTime postedAt) {
			this.postedAt = postedAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "Job [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
					+ ", salary=" + salary + ", jobType=" + jobType + ", recruiter=" + recruiter + ", postedAt="
					+ postedAt + ", updatedAt=" + updatedAt + "]";
		}

		public Job(Long id, String title, String description, String location, Double salary, String jobType,
				Users recruiter, LocalDateTime postedAt, LocalDateTime updatedAt) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.location = location;
			this.salary = salary;
			this.jobType = jobType;
			this.recruiter = recruiter;
			this.postedAt = postedAt;
			this.updatedAt = updatedAt;
		}

		public Job() {
			super();
			// TODO Auto-generated constructor stub
		}

	

}
