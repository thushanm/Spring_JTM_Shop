package com.example.springShop.service;

import com.example.springShop.entity.Customer;
import com.example.springShop.repositary.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CutomerService {
    @Autowired
    private  CustomerRepository customerRepository;



    public void saveCustomer(Customer customer){

        customerRepository.save(customer);
    }public void updateCustomer(Customer customer){

        customerRepository.save(customer);
    }
}
