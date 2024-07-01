package com.example.platform.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Customer customer;
    private Lawyer lawyer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSending;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Date getDateSending() {
        return dateSending;
    }

    public void setDateSending(Date dateSending) {
        this.dateSending = dateSending;
    }
}
