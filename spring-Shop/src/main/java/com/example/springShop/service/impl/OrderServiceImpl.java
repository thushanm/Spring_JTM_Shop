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
    private OrderRepository orderRepository;
  @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        System.out.println(orderDTO.getOrderDetailsList().get(0).getItem());
orderRepository.save(modelMapper.map(orderDTO, Order.class));

//
//    for (OrderDetails orderDetails:order.getOrderDetailsList()) {
//
//        System.out.println("oky da");
//   Item item = itemRepository.findById(orderDetails.getItem().getItemId()).get();
//      item.setItemQty(item.getItemQty()-orderDetails.getQty());
//
//    }
//
//     Payment payment = new Payment();
//payment.setPrice(order.getItemPrice());
// payment.setPayId(order.getOrderId());
// payment.setDateTime(order.getDateTime());
// payment.setCustomerName(String.valueOf(order.getCustomerName()));
// payment.setPayType(order.getPayType());
//
//      paymentRepository.save(payment);

      return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO searchOrder(int id) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}
