package com.example.springShop.repositary;

import com.example.springShop.entity.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Suppliers,Integer> {

}
