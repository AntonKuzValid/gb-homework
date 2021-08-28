package com.example.spring_boot.repository;

import com.example.spring_boot.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final List<Product> productDB  = new CopyOnWriteArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    public ProductRepository(){
        Product product1 = new Product();
        product1.setTitle("Avocado");
        product1.setCompany("Fruits and Co");
        product1.setCost(7);
        save(product1);

        Product product2 = new Product();
        product2.setTitle("Orange");
        product2.setCompany("Turkey Fruits Company");
        product2.setCost(4);
        save(product2);

        Product product3 = new Product();
        product3.setTitle("Kiwi");
        product3.setCompany("Thai plants");
        product3.setCost(5);
        save(product3);
    }

    public List<Product> findAll(){
        return productDB.stream().collect(Collectors.toUnmodifiableList());
    }

    public void save(Product product) {
        product.setId(counter.incrementAndGet());
        productDB.add(product);
    }

    public void deleteById(Integer id) {
        productDB.removeIf(it -> it.getId().equals(id));
    }
}
