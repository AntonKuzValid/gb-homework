package ru.geekbrains.data.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.data.entity.Product;
import ru.geekbrains.data.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRepositoryService {

    private static final Integer INPUTS_NUMBER = 10;

    @Autowired
    private ProductRepository pr;

    public List<Product> findPage(Integer page) {
        Pageable pageable = PageRequest.of(page-1, INPUTS_NUMBER);
        Page<Product> list = pr.findAll(pageable);
        return list.stream().toList();
    }

    public void deleteById(long id) {
        pr.deleteById(id);
    }

    public Product save(Product p) {
        return pr.save(p);
    }

    public Optional<Product> findById(long id) {
        return pr.findById(id);
    }

    public List<Product> findAll(Specification<Product> filtered) {
        return pr.findAll(filtered);
    }
}
