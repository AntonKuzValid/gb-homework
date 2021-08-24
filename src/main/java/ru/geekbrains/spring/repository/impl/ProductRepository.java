package ru.geekbrains.spring.repository.impl;

import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.repository.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository<Product> {

    private final List<Product> rep;
    private AtomicInteger id;

    public ProductRepository() {
        rep = new CopyOnWriteArrayList<>();
        id = new AtomicInteger(0);
    }

    @Override
    public List<Product> getAll() {
        return rep.stream().toList();
    }

    @Override
    public Product getById(Integer id) {
        try {
            return rep.get(--id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean add(Product product) {
        product.setId(id.incrementAndGet());
        return rep.add(product);
    }

    @Override
    public boolean deleteById(Integer id) {
        return rep.removeIf(i -> i.getId().equals(id));
    }

    @Override
    public boolean update(Product product, Integer id) {
        Product p = getById(id);
        if (p != null) {
            p.setCompany(product.getCompany());
            p.setCost(product.getCost());
            p.setTitle(product.getTitle());
            return true;
        }
        return false;
    }
}
