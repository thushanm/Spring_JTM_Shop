package com.example.springShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int itemQty;
    private double itemPrice;
    @Lob
    @Column( columnDefinition = "MEDIUMBLOB")
    private byte[] itemImg;
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderDetails> orderDetails;

}
