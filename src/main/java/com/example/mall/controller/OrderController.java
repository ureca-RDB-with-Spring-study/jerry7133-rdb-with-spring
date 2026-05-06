package com.example.mall.controller;

import com.example.mall.dto.CustomerDto;
import com.example.mall.dto.OrderDto;
import com.example.mall.service.CustomerService;
import com.example.mall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/order/{id}")
    public OrderDto findOrder(@PathVariable("id") int orderId) {
        return orderService.getOrderById(orderId);
    }
}
