package com.example.springShop.service;

import com.example.springShop.dto.OrderDTO;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(OrderDTO orderDTO);
    OrderDTO searchOrder(int id);
    void deleteOrder(int id);

}
