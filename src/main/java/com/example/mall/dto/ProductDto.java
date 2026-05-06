package com.example.mall.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int productId;
    private String name;
    private String text;
    private int price;
    private int stock_quantity;
}
