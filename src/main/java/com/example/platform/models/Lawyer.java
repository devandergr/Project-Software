package com.example.platform.models;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Lawyer extends User {
    private List<Message> messages;
    private String area;
    private String experience;
    private Double scoreAverage;
    public Lawyer(){
        this.setUserType(UserType.LAWYER);
    }

    // Methods
}
