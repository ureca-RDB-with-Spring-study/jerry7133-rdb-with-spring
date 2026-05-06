package com.example.mall.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int orderId;
    private int customerId;
    private int productId;
    private int quantity;
    private Timestamp joinDate;
    private String status;
}
