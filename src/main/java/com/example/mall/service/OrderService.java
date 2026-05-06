package com.example.mall.service;

import com.example.mall.dto.OrderDto;
import com.example.mall.dto.ProductDto;
import com.example.mall.mapper.OrderMapper;
import com.example.mall.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public void saveOrder(OrderDto order) {
        orderMapper.save(order);
    }

    public List<OrderDto> getOrders() {
        List<OrderDto> orders = orderMapper.getOrders();
        return orders;
    }

    public OrderDto getOrderById(int orderId) {
        OrderDto order = orderMapper.getOrderById(orderId);
        return order;
    }
}
