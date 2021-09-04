package ru.geekbrains.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.data.advice.annotation.ProductDatabaseException;
import ru.geekbrains.data.entity.Product;
import ru.geekbrains.data.repository.ProductRepository;
import ru.geekbrains.data.repository.spec.Filter;
import ru.geekbrains.data.repository.spec.ProductSpec;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
@ProductDatabaseException
public class ProductController {

    @Autowired
    private ProductRepository pr;

    @GetMapping(value = "/all")
    public List<Product> getAll() {
        return pr.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable String id) {
        return pr.findById(Long.parseLong(id)).get();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return pr.save(p);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable String id) {
        pr.deleteById(Long.parseLong(id));

    }

    @GetMapping(value = "/filter")
    public List<Product> findFiltered(@RequestBody Filter filter) {
        return pr.findAll(ProductSpec.getFiltered(filter));
    }
}
