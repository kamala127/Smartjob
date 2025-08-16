package com.smartjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjob.entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Long>{

}
