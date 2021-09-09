package ru.gb.lesson4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.lesson4.model.Product;
import ru.gb.lesson4.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
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
