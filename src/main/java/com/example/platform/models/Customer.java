package com.example.platform.models;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Customer extends User {
    private List<Message> messages;
    public Customer(){
        this.setUserType(UserType.CUSTOMER);
    }

    // Methods
}
