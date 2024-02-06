package com.example.springShop.service.impl;

import com.example.springShop.dto.SupplierDTO;
import com.example.springShop.entity.Suppliers;
import com.example.springShop.repositary.SupplierRepository;
import com.example.springShop.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SupplierRepository supplierRepository;


    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
    supplierRepository.save(modelMapper.map(supplierDTO, Suppliers.class));
    return supplierDTO;

    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public SupplierDTO searchSupplier(int id) {
        return null;
    }

    @Override
    public void deleteSupplier(int id) {

    }
}



