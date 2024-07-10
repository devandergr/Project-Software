package com.example.platform.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
 @Entity
    public class Profile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer userID;

        private String photo;
        private String description;
        private String comments;

        @OneToOne
        @MapsId
        @JoinColumn(name = "userID")
        @JsonBackReference
        private User user;

     public Integer getUserID() {
         return userID;
     }

     public String getPhoto() {
         return photo;
     }

     public String getDescription() {
         return description;
     }

     public User getUser() {
         return user;
     }

     public String getComments() {
         return comments;
     }

     public void setPhoto(String photo) {
         this.photo = photo;
     }

     public void setUserID(Integer userID) {
         this.userID = userID;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public void setUser(User user) {
         this.user = user;
     }

     public void setComments(String comments) {
         this.comments = comments;
     }
 }
