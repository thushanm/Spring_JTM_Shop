package com.example.springShop.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int payId;
        private String customerName;
        private String payType;
        private double price;
        @Temporal(TemporalType.TIMESTAMP)
        private LocalDateTime dateTime;


}
