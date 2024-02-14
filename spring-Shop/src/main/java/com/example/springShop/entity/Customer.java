package com.example.springShop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int number;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="customerName")
    private List<Order> orderDetails;
}
