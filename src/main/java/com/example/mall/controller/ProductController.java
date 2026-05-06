package com.example.mall.controller;

import com.example.mall.dto.CustomerDto;
import com.example.mall.dto.ProductDto;
import com.example.mall.service.CustomerService;
import com.example.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/{id}")
    public ProductDto findProduct(@PathVariable("id") int productId) {
        return productService.getProductById(productId);
    }
}
