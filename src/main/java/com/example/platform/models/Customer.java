package com.example.platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer extends User {

<<<<<<< Updated upstream
    @OneToMany(mappedBy = "customer")
    private List<Message> messages;
    public Customer(){
        this.setUserType(UserType.CUSTOMER);
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

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
