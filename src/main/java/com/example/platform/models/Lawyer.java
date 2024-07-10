package com.example.platform.models;

import jakarta.persistence.*;

@Entity

public class Lawyer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    private String speciality;
    private int experience;
    private double averageRating;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @MapsId
    @JoinColumn(name = "userID")
    private User user;

    public Integer getUserID() {
        return userID;
    }

    public String getSpecialty() {
        return speciality;
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

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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