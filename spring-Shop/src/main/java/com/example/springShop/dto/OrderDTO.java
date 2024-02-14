package com.example.springShop.dto;

import com.example.springShop.entity.Customer;
import com.example.springShop.entity.Item;
import com.example.springShop.entity.OrderDetails;
import com.example.springShop.entity.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
        private int orderId;
        @Temporal(TemporalType.TIMESTAMP)
        private LocalDateTime dateTime;
        private Customer customerName;
        private double itemPrice;
        private String payType;
        private List<OrderDetails> orderDetailsList;
}
