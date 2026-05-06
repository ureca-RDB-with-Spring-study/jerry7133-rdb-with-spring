package com.example.mall.service;

import com.example.mall.dto.CustomerDto;
import com.example.mall.mapper.CustomerMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;

    public void saveCustomer(CustomerDto cust) {
        customerMapper.save(cust);
    }

    public List<CustomerDto> getCustomers() {
        List<CustomerDto> custs = customerMapper.getCustomers();
        return custs;
    }

    public CustomerDto getCustomersById(int customerId) {
        CustomerDto cust = customerMapper.getCustomerById(customerId);
        return cust;
    }
}
