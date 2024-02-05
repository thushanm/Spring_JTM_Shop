package com.example.springShop.service.impl;

import com.example.springShop.dto.CustomerDTO;
import com.example.springShop.entity.Customer;
import com.example.springShop.repositary.CustomerRepository;
import com.example.springShop.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CutomerServiceImpl  implements CustomerService {
    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
private ModelMapper modelMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
customerRepository.save(modelMapper.map(customerDTO, Customer.class));
return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        customerRepository.save(modelMapper.map(customerDTO, Customer.class));

        return customerDTO;

    }

    @Override
    public CustomerDTO searchCustomer(int keyword) {
     Customer customer=customerRepository.findById(keyword).orElse(null);

     if (customer != null){
        return modelMapper.map(customer, CustomerDTO.class);
     }
     else {
         return null;
     }

    }
    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);

    }

}
