package com.example.platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Lawyer extends User {

    @OneToMany(mappedBy = "lawyer")
    private List<Message> messages;
    private String area;
    private String experience;
    private Double scoreAverage;

<<<<<<< Updated upstream
    public Lawyer(){
        this.setUserType(UserType.LAWYER);
=======
    private String specialty;
    private int experience;
    private double averageRating;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userID")
    private User user;

    public Long getUserID() {
        return userID;
>>>>>>> Stashed changes
    }

    // Methods
}
