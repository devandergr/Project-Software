package com.example.platform.repositories;

import com.example.platform.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllById(Long userId);
}