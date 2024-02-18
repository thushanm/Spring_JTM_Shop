package com.example.springShop.service;

import com.example.springShop.dto.CustomerDTO;
import com.example.springShop.entity.Customer;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);

  CustomerDTO searchCustomer(int keyword);

  void deleteCustomer(int id);

}
