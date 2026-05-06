package com.example.mall.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private int customerId;
    private String name;
    private String email;
    private String password;
    private String address;
    private Timestamp joinDate;
}
