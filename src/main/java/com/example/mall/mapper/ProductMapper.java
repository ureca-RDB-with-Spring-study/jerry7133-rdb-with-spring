package com.example.mall.mapper;

import com.example.mall.dto.CustomerDto;
import com.example.mall.dto.OrderDto;
import com.example.mall.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void save(@Param("product") ProductDto productDto);
    List<ProductDto> getProducts();
    ProductDto getProductById(@Param("productId") int productId);
}
