package com.smartjob.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjob.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{
	
	boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
    Optional<Users> findByUsername(String username);
   

}
