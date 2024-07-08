package com.example.platform.controllers;

import com.example.platform.models.Session;
import com.example.platform.models.User;
import com.example.platform.models.UserType;
import com.example.platform.repositories.UserRepository;
import com.example.platform.services.AuthService;
import com.example.platform.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthService authService;

    @Autowired
    private SessionService sessionService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        } catch (Exception e) {
            throw new Exception("Incorrect email or password", e);
        }
        //Crear la sesión
        User loggedInuser = userRepository.findByEmail(user.getEmail());
        Session session = new Session();
        session.setUser(loggedInuser);
        session.setStartDateTime(LocalDateTime.now());
        sessionService.crearSession(session);
        return ResponseEntity.ok("Login successful");
    }
    /*text-comment*/

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> request) {
        User user = new User();
        user.setName((String) request.get("name"));
        user.setEmail((String) request.get("email"));
        user.setPassword((String) request.get("password"));
        user.setUserType(UserType.valueOf((String) request.get("userType")));
        if (user.getUserType() == UserType.Lawyer) {
            String speciality = (String) request.get("speciality");
            int experience = (Integer) request.get("experience");
            double averageRating = ((Number) request.get("averageRating")).doubleValue();
            authService.registerLawyer(user, speciality, experience, averageRating);
        } else {
            authService.registerUser(user);
        }
        return ResponseEntity.ok("User registered successfully");
    }
}


