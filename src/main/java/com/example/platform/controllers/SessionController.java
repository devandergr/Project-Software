package com.example.platform.controllers;

import com.example.platform.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logout")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<?> deleteSession(@PathVariable Integer sessionId) {
        sessionService.deleteSession(sessionId);
        return ResponseEntity.ok("Session deleted successfully");
    }
}