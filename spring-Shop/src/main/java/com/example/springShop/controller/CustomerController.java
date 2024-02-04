package com.example.springShop.controller;

import com.example.springShop.entity.Customer;
import com.example.springShop.repositary.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/cusSave")

    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){

        customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }

}
