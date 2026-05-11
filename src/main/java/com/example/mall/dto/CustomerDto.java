package com.example.mall.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long customerId;
    private String name;
    private String email;
    private String password;
    private String address;
    private Timestamp joinDate;

    public CustomerDto(SignupRequest signupRequest) {
        this.name = signupRequest.getName();
        this.email = signupRequest.getEmail();
        this.password = signupRequest.getPassword();
        this.address = signupRequest.getAddress();
    }
}
