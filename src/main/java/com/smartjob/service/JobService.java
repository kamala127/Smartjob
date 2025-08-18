package com.smartjob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.smartjob.dto.CreateJobDto;
import com.smartjob.entity.Job;
import com.smartjob.entity.Users;
import com.smartjob.repository.JobRepo;
import com.smartjob.repository.UsersRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo jobRepo;
	
	@Autowired
	private UsersRepo userRepo;

	public ResponseEntity<String> createJob(CreateJobDto dto) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users recruiter = userRepo.findByUsername(username)
		    .orElseThrow(() -> new RuntimeException("Recruiter not found"));

	    Job job = new Job();
	    job.setTitle(dto.getTitle());
	    job.setDescription(dto.getDescription());
	    job.setLocation(dto.getLocation());
	    job.setSalary(dto.getSalary());
	    job.setJobType(dto.getJobType());
	    job.setRecruiter(recruiter);

	    jobRepo.save(job);

	    return new ResponseEntity<>("Job Created!", HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateJob(Long jobid, CreateJobDto dto) {
		Job job = jobRepo.findById(jobid)
			    .orElseThrow(() -> new RuntimeException("Job not found"));
		job.setTitle(dto.getTitle());
	    job.setDescription(dto.getDescription());
	    job.setLocation(dto.getLocation());
	    job.setSalary(dto.getSalary());
	    job.setJobType(dto.getJobType());
	    jobRepo.save(job);
	    return new ResponseEntity<>("Job Updated!", HttpStatus.OK);
	}

	public ResponseEntity<String> deleteJob(Long jobid) {
		if(jobRepo.existsById(jobid)) {
			jobRepo.deleteById(jobid);
			return new ResponseEntity<String>("Job Deleted!",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Job Not Found!",HttpStatus.NOT_FOUND);
		}
	}

	
	
	

}
