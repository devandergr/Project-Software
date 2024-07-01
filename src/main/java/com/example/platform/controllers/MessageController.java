package com.example.platform.controllers;

import com.example.platform.models.Customer;
import com.example.platform.models.Lawyer;
import com.example.platform.models.Message;
import com.example.platform.repositories.MessageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Message>> getMessageCustomer(@PathVariable Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        List<Message> messages = messageRepository.findByCustomer(customer);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/lawyer/{lawyerId}")
    public ResponseEntity<List<Message>> getMessageLawyer(@PathVariable Long lawyerId) {
        Lawyer lawyer = entityManager.find(Lawyer.class, lawyerId);
        if (lawyer == null) {
            return ResponseEntity.notFound().build();
        }
        List<Message> messages = messageRepository.findByLawyer(lawyer);
        return ResponseEntity.ok(messages);
    }
}
