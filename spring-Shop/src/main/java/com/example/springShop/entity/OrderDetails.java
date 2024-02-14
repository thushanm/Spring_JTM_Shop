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
    private int orderId;
    @Id
    private int itemId;
    @ManyToOne
    @JoinColumn(name = "orderId",insertable = false,updatable = false)
    Order order;
    @ManyToOne
    @JoinColumn(name = "itemId",insertable = false,updatable = false)
    Item item;
    private int qty;
}
