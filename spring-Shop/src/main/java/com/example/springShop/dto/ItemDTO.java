package com.example.springShop.dto;

import com.example.springShop.entity.Suppliers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private int itemId;
    private String itemName;
    private int itemQty;
    private double itemPrice;
    private byte[] itemImg;
    private Suppliers suppliers;
}
