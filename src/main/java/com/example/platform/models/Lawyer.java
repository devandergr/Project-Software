package com.example.platform.models;

import java.util.List;

public class Lawyer extends User {
    private List<Message> messages;
    public Lawyer(){
        this.setUserType(UserType.LAWYER);
    }

    // Methods
}
