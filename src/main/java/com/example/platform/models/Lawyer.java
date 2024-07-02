package com.example.platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Lawyer extends User {

    @OneToMany(mappedBy = "lawyerId")
    private List<Message> messages;
    private String area;
    private String experience;
    private Double scoreAverage;

    public Lawyer(){
        this.setUserType(UserType.LAWYER);
    }

    // Methods
}
