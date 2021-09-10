package ru.geekbrains.data.controller;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/api/v1/product")
@Tag(name = "Контроллер продукта", description = "Product api")
public class ProductController {

    @Autowired
    private ProductRepositoryService prs;

    @GetMapping(value = "/{id}")
    @Tag(name = "Get page")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getPage(@ApiParam(name = "id", required = true)
                                 @PathVariable String id) {
        return prs.findPage(Integer.parseInt(id));
    }

    @GetMapping(value = "/single/{id}")
    @Tag(name = "Get product by id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> getById(@ApiParam(name = "id", required = true) @PathVariable String id) {
        return prs.findById(Long.parseLong(id));
    }

    @PostMapping
    @Tag(name = "Add product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product addProduct(@RequestBody Product p) {
        return prs.save(p);
    }

    @DeleteMapping(value = "/{id}")
    @Tag(name = "Delete product")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public void deleteById(@ApiParam(name = "id", required = true) @PathVariable String id) {
        prs.deleteById(Long.parseLong(id));
    }

    @PostMapping(value = "/filter")
    @Tag(name = "Get filtered products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findFiltered(@RequestBody Filter filter) {
        return prs.findAll(ProductSpec.getFiltered(filter));
    }
}
