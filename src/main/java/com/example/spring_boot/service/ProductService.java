package com.example.spring_boot.service;

import com.example.spring_boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void show() {
        System.out.println("ProductService");
        productRepository.show();
    }
}
