package com.example.springShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetails_PK.class)
public class OrderDetails  {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "itemId")
    Item item;
    private int qty;
}
