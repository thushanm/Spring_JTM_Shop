package com.example.springShop.service;

import com.example.springShop.dto.SupplierDTO;

public interface SupplierService {
SupplierDTO saveSupplier(SupplierDTO supplierDTO);
SupplierDTO updateSupplier(SupplierDTO supplierDTO);

SupplierDTO searchSupplier(int id);

void deleteSupplier(int id);

}
