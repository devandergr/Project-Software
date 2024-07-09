package com.example.platform.controllers;

import com.example.platform.models.Customer;
import com.example.platform.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println("Retrieved customers: " + customers);
        return ResponseEntity.ok(customers);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer with ID " + id + " has been successfully deleted.");
    }
}
