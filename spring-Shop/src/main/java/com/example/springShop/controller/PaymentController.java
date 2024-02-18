package com.example.springShop.controller;

import com.example.springShop.dto.PaymentDTO;
import com.example.springShop.service.PaymentService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


        @PostMapping("/save")
        public ResponseEntity<PaymentDTO> paymentSave(@RequestBody PaymentDTO paymentDTO){
            return ResponseEntity.ok(paymentService.savePayment(paymentDTO));
        }
        @PutMapping("/update")
public ResponseEntity<PaymentDTO> paymentUpdate(@RequestBody PaymentDTO paymentDTO){

            return ResponseEntity.ok(paymentService.updatePayment(paymentDTO));
}
@GetMapping("/search/{id}")
        public ResponseEntity<PaymentDTO> searchPayment(@PathVariable int id){

     return ResponseEntity.ok(paymentService.searchPayment(id));
}

    }

