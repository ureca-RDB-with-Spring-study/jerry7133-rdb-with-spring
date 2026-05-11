package com.example.mall.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class SignupRequest {

    private String name;
    private String email;
    private String password;
    private String address;
}
