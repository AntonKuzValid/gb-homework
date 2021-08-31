package ru.geekbrains.webstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webstore.dao.ProductDao;
import ru.geekbrains.webstore.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Product getProduct(@PathVariable String id) {
        return productDao.getProduct(Integer.parseInt(id));
    }

    @GetMapping
    public List<Product> getAll() {
        return productDao.getAllProduct();
    }

    @PostMapping
    public boolean addProduct(@RequestBody Product p) {
        return productDao.addProduct(p);
    }

    @PatchMapping
    public boolean updateProduct(@RequestBody Product p) {
        return productDao.updateProduct(p);
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method = RequestMethod.DELETE)
    public boolean deleteProduct(@PathVariable String id) {
        return productDao.deleteProduct(Integer.parseInt(id));
    }
}
