package com.example.platform.models;


import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Long getUserID() {
        return userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    // Getters and Setters
}
