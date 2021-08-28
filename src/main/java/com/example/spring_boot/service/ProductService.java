package com.example.spring_boot.service;

import com.example.spring_boot.model.Product;
import com.example.spring_boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
