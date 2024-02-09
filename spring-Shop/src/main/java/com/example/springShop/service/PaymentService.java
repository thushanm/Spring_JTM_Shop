package com.example.springShop.service;

import com.example.springShop.dto.PaymentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentService {

PaymentDTO savePayment(PaymentDTO paymentDTO);
PaymentDTO updatePayment(PaymentDTO paymentDTO);
PaymentDTO searchPayment(int id);
}
