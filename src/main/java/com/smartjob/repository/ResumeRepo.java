package com.smartjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjob.entity.Resume;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long>{

}
