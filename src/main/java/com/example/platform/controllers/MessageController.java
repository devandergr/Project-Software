package com.example.platform.controllers;

import com.example.platform.models.Message;
import com.example.platform.repositories.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageRepository messageRepository;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Message>> getMessageCustomer(@PathVariable Long customerId) {
        List<Message> messages = messageRepository.findCustomerById(customerId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/lawyer/lawyerId")
    public ResponseEntity<List<Message>> getMessageLawyer(@PathVariable Long lawyerId) {
        List<Message> messages = messageRepository.findLawyerById(lawyerId);
        return ResponseEntity.ok(messages);
    }
}
