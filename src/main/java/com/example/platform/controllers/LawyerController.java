package com.example.platform.controllers;

import com.example.platform.models.Customer;
import com.example.platform.models.Lawyer;
import com.example.platform.repositories.LawyerRepository;
import com.example.platform.services.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Lawyer>> getAllSessions(){
        List<Lawyer> lawyers = lawyerService.getAllLawyers();
        return ResponseEntity.ok(lawyers);
    }

    @PostMapping("/create")
    public Lawyer createLawyer(@RequestBody Lawyer lawyer) {
        return lawyerService.saveLawyer(lawyer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lawyer> getLawyerById(@PathVariable Long id) {
        Lawyer lawyer = lawyerService.getLawyerById(id);
        if (lawyer == null) {
            throw new ResourceNotFoundException("Lawyer not found");
        }
        return ResponseEntity.ok(lawyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLawyer(@PathVariable Long id){
        lawyerService.deleteLawyer(id);
        return ResponseEntity.noContent().build();
    }
}
