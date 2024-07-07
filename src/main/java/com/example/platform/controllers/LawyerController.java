package com.example.platform.controllers;

import com.example.platform.models.Lawyer;
import com.example.platform.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lawyers")
public class LawyerController {

    @Autowired
    private LawyerRepository lawyerRepository;

    @GetMapping
    public List<Lawyer> getAllLawyers() {
        return lawyerRepository.findAll();
    }

    @PostMapping
    public Lawyer createLawyer(@RequestBody Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lawyer> getLawyerById(@PathVariable Long id) {
        Lawyer lawyer = lawyerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lawyer not found"));
        return ResponseEntity.ok(lawyer);
    }
}
