package com.example.platform.models;

import javax.persistence.*;

@Entity
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String specialty;
    private int experience;
    private double averageRating;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userID")
    private User user;

    public Long getUserID() {
        return userID;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getExperience() {
        return experience;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public User getUser() {
        return user;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setUser(User user) {
        this.user = user;
    }
}