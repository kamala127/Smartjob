package com.smartjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjob.entity.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {

}
