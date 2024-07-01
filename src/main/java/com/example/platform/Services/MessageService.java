package com.example.platform.services;

import com.example.platform.models.Message;
import com.example.platform.models.Customer;
import com.example.platform.models.Lawyer;
import com.example.platform.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Método para enviar un mensaje desde un Customer a un Lawyer
    public Message sendMessage(Customer customer, Lawyer lawyer, String description) {
        Message newMessage = new Message();
        newMessage.setCustomer(customer);
        newMessage.setLawyer(lawyer);
        newMessage.setDescription(description);
        newMessage.setDateSending(new Date()); // Establecer la fecha y hora actual del envío
        return messageRepository.save(newMessage);
    }

    // Método para obtener los mensajes recibidos por un Lawyer
    public List<Message> getMessagesReceivedByLawyer(Lawyer lawyer) {
        return messageRepository.findByLawyer(lawyer);
    }

    // Método para obtener los mensajes enviados por un Customer
    public List<Message> getMessagesSentByCustomer(Customer customer) {
        return messageRepository.findByCustomer(customer);
    }
}
