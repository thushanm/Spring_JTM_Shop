package com.example.springShop.entity;

import jakarta.persistence.Id;

import java.io.Serializable;

public class OrderDetails_PK implements Serializable {
    private int orderId;
    private int itemId;
}
