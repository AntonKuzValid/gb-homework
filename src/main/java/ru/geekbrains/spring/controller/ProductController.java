package ru.geekbrains.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.repository.Repository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private Repository<Product> productRepository;

    @PostMapping
    public String addProduct(@RequestBody @Valid Product p) {
        productRepository.add(p);
        return "Success";
    }

    @GetMapping
    public List<Product> getAll() throws InterruptedException {
        Thread.sleep(1000);
        return productRepository.getAll();
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method=RequestMethod.DELETE)
    public String deleteById(@PathVariable String id) {
        return productRepository.deleteById(Integer.parseInt(id)) ? "success" : "Unable to delete " + id;
    }

    @RequestMapping(value = "/{id}",
            produces = "application/json",
            method = RequestMethod.PATCH)
    public String updateById(@PathVariable String id, @RequestBody @Valid Product p) {
        return productRepository.update(p, Integer.parseInt(id))
                ? "success" : "Unable to update " + p.toString() + " " + id;
    }
}
