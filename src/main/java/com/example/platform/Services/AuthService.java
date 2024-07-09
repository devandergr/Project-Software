package com.example.platform.services;

import com.example.platform.models.*;
import com.example.platform.repositories.CustomerRepository;
import com.example.platform.repositories.LawyerRepository;
import com.example.platform.repositories.ProfileRepository;
import com.example.platform.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //userRepository.save(user);
        if (user.getUserType() == UserType.Customer) {
            Customer customer = new Customer();
            customer.setUser(user);
            customerRepository.save(customer);

            Profile profile = new Profile();
            profile.setUser(user);
            profileRepository.save(profile);
        }
    }

    @Transactional
    public void registerLawyer(User user, String speciality, int experience, double averageRating) {
        registerUser(user);
        Lawyer lawyer = new Lawyer();
        lawyer.setUser(user);
        lawyer.setSpeciality(speciality);
        lawyer.setExperience(experience);
        lawyer.setAverageRating(averageRating);
        lawyerRepository.save(lawyer);

        Profile profile = new Profile();
        profile.setUser(user);
        profileRepository.save(profile);
    }

}

