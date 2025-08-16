package com.smartjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjob.entity.Notification;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long>{

}
