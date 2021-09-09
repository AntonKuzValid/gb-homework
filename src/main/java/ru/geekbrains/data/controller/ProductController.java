package ru.geekbrains.data.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.data.advice.annotation.ProductDatabaseException;
import ru.geekbrains.data.entity.Product;
import ru.geekbrains.data.repository.spec.Filter;
import ru.geekbrains.data.repository.spec.ProductSpec;
import ru.geekbrains.data.service.ProductRepositoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@ProductDatabaseException
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepositoryService prs;

    @GetMapping(value = "/{id}")
    public List<Product> getPage(@PathVariable String id) {
        return prs.findPage(Integer.parseInt(id));
    }

    @GetMapping(value = "/single/{id}")
    public Optional<Product> getById(@PathVariable String id) {
        return prs.findById(Long.parseLong(id));
    }

    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return prs.save(p);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable String id) {
        prs.deleteById(Long.parseLong(id));
    }

    @PostMapping(value = "/filter")
    public List<Product> findFiltered(@RequestBody Filter filter) {
        return prs.findAll(ProductSpec.getFiltered(filter));
    }
}
