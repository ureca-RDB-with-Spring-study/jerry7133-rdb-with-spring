package com.example.mall.service;

import com.example.mall.dto.CustomerDto;
import com.example.mall.dto.SignupRequest;
import com.example.mall.mapper.CustomerMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

        private final CustomerMapper customerMapper;

        public CustomerDto signup(SignupRequest signupRequest) {
            CustomerDto customerDto = new CustomerDto(signupRequest);
            customerMapper.save(customerDto);
            return customerDto;
        }

        public void saveCustomer(CustomerDto cust) {
            customerMapper.save(cust);
        }

        public CustomerDto login(String id, String password) {
            return customerMapper.login(id, password);
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
