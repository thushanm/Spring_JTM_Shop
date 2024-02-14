package com.example.springShop.controller;

import com.example.springShop.dto.OrderDTO;
import com.example.springShop.service.OrderService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class PlaceOrder {
    @Autowired
    private OrderService orderService;
@PostMapping("save")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
    System.out.println(orderDTO.getOrderDetailsList());

        return  ResponseEntity.ok(orderService.saveOrder(orderDTO));
    }




}
