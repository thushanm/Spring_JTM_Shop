package com.example.springShop.service.impl;

import com.example.springShop.dto.OrderDTO;
import com.example.springShop.dto.PaymentDTO;
import com.example.springShop.entity.*;
import com.example.springShop.repositary.*;
import com.example.springShop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
  @Autowired
    private ModelMapper modelMapper;


@Transactional
    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
    Order save = orderRepository.save(modelMapper.map(orderDTO, Order.class));

    for (OrderDetails orderDetails: save.getOrderDetailsList() ) {
        Item item = itemRepository.findById(orderDetails.getItemId()).get();
        item.setItemQty(item.getItemQty()-orderDetails.getQty());
        itemRepository.save(item);

    }

    Payment payment = new Payment();
payment.setPrice(orderDTO.getItemPrice());
payment.setPayType(orderDTO.getPayType());
payment.setPayId(orderDTO.getOrderId());
payment.setCustomerName(String.valueOf(orderDTO.getCustomerName().getName()));
payment.setDateTime(orderDTO.getDateTime());

paymentRepository.save(payment);

    return orderDTO;
    }
    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {

            orderRepository.save(modelMapper.map(orderDTO, Order.class));


    return orderDTO;
    }
    @Override
    public OrderDTO searchOrder(int id) {
     Order order = orderRepository.findById(id).orElse(null);
     if (order != null){
         return modelMapper.map(order,OrderDTO.class);
     }
     return null;
    }
    @Override
    public void deleteOrder(int id) {
orderRepository.deleteById(id);
    }
}
