package com.example.spring_boot.service;

import com.example.spring_boot.model.Products;
import com.example.spring_boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Products> selectAll() {
        return productRepository.selectAll();
    }

    public void removeFromDB(Integer id) {
        productRepository.removeFromDB(id);
    }
}
