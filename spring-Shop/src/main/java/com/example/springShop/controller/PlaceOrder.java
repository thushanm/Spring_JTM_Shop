package com.example.springShop.controller;

import com.example.springShop.dto.OrderDTO;
import com.example.springShop.service.OrderService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO orderDTO){

        return  ResponseEntity.ok(orderService.updateOrder(orderDTO));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<OrderDTO> searchOrder(@PathVariable int id){

    return ResponseEntity.ok(orderService.searchOrder(id));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable int id){
orderService.deleteOrder(id);
return new ResponseEntity<>(null,HttpStatus.OK);
    }




}
