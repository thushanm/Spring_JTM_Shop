package com.example.springShop.service.impl;

import com.example.springShop.dto.PaymentDTO;
import com.example.springShop.entity.Payment;
import com.example.springShop.repositary.PaymentRepository;
import com.example.springShop.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO) {

        paymentRepository.save(modelMapper.map(paymentDTO, Payment.class));
        return paymentDTO;
    }

    @Override
    public PaymentDTO updatePayment(PaymentDTO paymentDTO) {


        paymentRepository.save(modelMapper.map(paymentDTO, Payment.class));
        return paymentDTO;
    }

    @Override
    public PaymentDTO searchPayment(int id) {
        Payment payment = paymentRepository.findById(id).orElse(null);

        if (payment != null) {
            return modelMapper.map(payment, PaymentDTO.class);
        } else {

            return null;
        }

    }
}
