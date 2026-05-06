package com.example.mall.mapper;

import com.example.mall.dto.CustomerDto;
import com.example.mall.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    void save(@Param("order") OrderDto orderDto);
    List<OrderDto> getOrders();
    OrderDto getOrderById(@Param("orderId") int orderId);
}
