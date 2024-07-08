package com.example.platform.services;

import com.example.platform.models.Customer;
import com.example.platform.models.Lawyer;
import com.example.platform.models.User;
import com.example.platform.models.UserType;
import com.example.platform.repositories.CustomerRepository;
import com.example.platform.repositories.LawyerRepository;
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
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Guardar el usuario
        User savedUser = userRepository.save(user);

        // Si el tipo de usuario es Customer, crear y guardar el Customer asociado
        if (user.getUserType() == UserType.Customer) {
            Customer customer = new Customer();
            customer.setUser(savedUser);
            customerRepository.save(customer);
            Customer savedCustomer = customerRepository.save(customer);
        } else if (user.getUserType() == UserType.Lawyer) {
            Lawyer lawyer = new Lawyer();
            lawyer.setUser(savedUser);
            lawyerRepository.save(lawyer);
        }
    }

    /*@Transactional
    public void registerLawyer(Lawyer lawyer) {
        User user = lawyer.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserType(UserType.Lawyer);

        User savedUser = userRepository.save(user);

        lawyer.setUser(savedUser);
        lawyerRepository.save(lawyer);
    }*/
}

