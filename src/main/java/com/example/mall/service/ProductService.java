package com.example.mall.service;

import com.example.mall.dto.ProductDto;
import com.example.mall.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void saveProduct(ProductDto product) {
        productMapper.save(product);
    }

    public List<ProductDto> getProducts() {
        List<ProductDto> products = productMapper.getProducts();
        return products;
    }

    public ProductDto getProductById(int customerId) {
        ProductDto product = productMapper.getProductById(customerId);
        return product;
    }
}
