package com.example.springShop.service.impl;

import com.example.springShop.dto.SupplierDTO;
import com.example.springShop.entity.Suppliers;
import com.example.springShop.repositary.SupplierRepository;
import com.example.springShop.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

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
       supplierRepository.save(modelMapper.map(supplierDTO,Suppliers.class));
       return supplierDTO;
    }

    @Override
    public SupplierDTO searchSupplier(int id) {

    Suppliers supplier=supplierRepository.findById(id).orElse(null);

    if (supplier !=  null){

      return modelMapper.map(supplier,SupplierDTO.class);
    }
        else {

            return null;
    }
    }

    @Override
    public void deleteSupplier(int id) {

        supplierRepository.deleteById(id);

    }
}



