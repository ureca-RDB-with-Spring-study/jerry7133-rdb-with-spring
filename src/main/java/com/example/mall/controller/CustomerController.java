package com.example.mall.controller;

import com.example.mall.dto.CustomerDto;
import com.example.mall.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/cust/{id}")
    public CustomerDto findCustomer(@PathVariable("id") int custId) {
        return customerService.getCustomersById(custId);
    }
}
