package com.example.springShop.controller;

import com.example.springShop.dto.CustomerDTO;
import com.example.springShop.entity.Customer;
import com.example.springShop.repositary.CustomerRepository;
import com.example.springShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController  {
    @Autowired
 private CustomerService customerService;

    @PostMapping("/cusSave")

    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){

        return ResponseEntity.ok(customerService.saveCustomer(customerDTO));
    }
    @PutMapping("/cusUpdate/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id,@RequestBody CustomerDTO customerDTO){
        System.out.println("Update Oky:"+customerDTO.getName()+"//"+customerDTO.getAddress());

       customerDTO.setId(id);
       customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok().build();

    }
    @GetMapping("/cusGet/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("id") int id){
        return new ResponseEntity<>(customerService.searchCustomer(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Integer id){

        customerService.deleteCustomer(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
