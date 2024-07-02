package com.example.platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer extends User {

    @OneToMany(mappedBy = "customerId")
    private List<Message> messages;
    public Customer(){
        this.setUserType(UserType.CUSTOMER);
    }

    // Methods
}
