package com.example.mall.mapper;

import com.example.mall.dto.CustomerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    void save(@Param("cust") CustomerDto customerDto);
    List<CustomerDto> getCustomers();
    CustomerDto getCustomerById(@Param("customerId") int customerId);
}
