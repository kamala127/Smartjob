package com.smartjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjob.dto.CreateJobDto;
import com.smartjob.entity.Job;
import com.smartjob.repository.JobRepo;
import com.smartjob.service.JobService;

@RestController
@RequestMapping("/recruiter")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobRepo jobRepo;
	
	
	@PostMapping("/create-job")
	public ResponseEntity<String> createJob(@RequestBody CreateJobDto dto){
	    return jobService.createJob(dto);
	}
	
	@GetMapping("/getall")
	public List<Job> findAll(){
		return jobRepo.findAll();
			
	}

	@PutMapping("/update-job/{jobid}")
	public ResponseEntity<String> updateJob(@PathVariable ("jobid")Long jobid,@RequestBody CreateJobDto dto ){
		ResponseEntity<String> response = jobService.updateJob(jobid,dto);
		return response;
	}

	@DeleteMapping("/delete-job/{jobid}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobid") Long jobid){
		ResponseEntity<String> response = jobService.deleteJob(jobid);
		return response;
	}
}
