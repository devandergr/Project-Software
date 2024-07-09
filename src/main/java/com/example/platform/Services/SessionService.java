package com.example.platform.services;

import com.example.platform.models.Session;
import com.example.platform.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public void crearSession(Session session) {
        sessionRepository.save(session);
    }
    /*
    public List<Session> getSessionByUser(Long userId) {
        return sessionRepository.findAllById(userId);
    }
    */
    public void deleteSession(Integer sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}