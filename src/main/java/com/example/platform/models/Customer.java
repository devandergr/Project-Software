package com.example.platform.models;

import java.util.List;

public class Customer extends User {
    private List<Message> messages;
    public Customer(){
        this.setUserType(UserType.CUSTOMER);
    }

    // Methods
}
