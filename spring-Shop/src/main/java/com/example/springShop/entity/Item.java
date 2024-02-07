package com.example.springShop.entity;

import com.example.springShop.entity.Suppliers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private int itemQty;
    private double itemPrice;
    @Lob
    @Column( columnDefinition = "MEDIUMBLOB")
    private byte[] itemImg;
    @ManyToOne
    @JoinColumn
    private Suppliers suppliers;
}
