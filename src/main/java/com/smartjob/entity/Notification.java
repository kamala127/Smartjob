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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users recipient;

    @Column(name = "is_read")
    private boolean read;

    private LocalDateTime sentAt;

    @PrePersist
    public void onCreate() { this.sentAt = LocalDateTime.now(); }
}
