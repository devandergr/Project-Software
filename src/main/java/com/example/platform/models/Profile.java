package com.example.platform.models;


import javax.persistence.*;
 @Entity
    public class Profile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userID;

        private String photo;
        private String description;
        private String comments;

        @OneToOne
        @MapsId
        @JoinColumn(name = "user_id")
        private User user;

     public Long getUserID() {
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

     public void setUserID(Long userID) {
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
