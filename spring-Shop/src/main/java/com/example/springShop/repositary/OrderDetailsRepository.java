package com.example.springShop.repositary;

import com.example.springShop.entity.Order;
import com.example.springShop.entity.OrderDetails;
import com.example.springShop.entity.OrderDetails_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetails_PK> {
}
