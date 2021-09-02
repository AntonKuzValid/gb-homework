package com.example.spring_boot.service;

import com.example.spring_boot.model.Product;
import com.example.spring_boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> selectAll() {
        return productRepository.selectAll();
    }

    public void removeFromDB(Long id) {
        productRepository.removeFromDB(id);
    }
}
