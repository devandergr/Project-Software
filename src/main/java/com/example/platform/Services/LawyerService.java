package com.example.platform.services;

import com.example.platform.models.Lawyer;
import com.example.platform.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawyerService {

    @Autowired
    private LawyerRepository lawyerRepository;

    public Lawyer saveLawyer(Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    public List<Lawyer> getAllLawyers() {
        return lawyerRepository.findAll();
    }

    public Lawyer getLawyerById(Integer id) {
        return lawyerRepository.findById(id).orElse(null);
    }

    public void deleteLawyer(Integer id) {
        lawyerRepository.deleteById(id);
    }
}