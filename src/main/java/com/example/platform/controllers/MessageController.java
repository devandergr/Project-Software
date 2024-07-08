/*
package com.example.platform.controllers;

import com.example.platform.models.Customer;
import com.example.platform.models.Lawyer;
import com.example.platform.models.Message;
import com.example.platform.services.MessageService
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping()
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
        return ResponseEntity.ok("Message saved successfully");
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Message>> getMessageCustomer(@PathVariable Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        List<Message> messages = messageService.getMessageById(customer);
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
*/