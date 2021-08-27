package ru.geekbrains.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.command.Sort;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.service.database.DatabaseAccess;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private DatabaseAccess databaseAccess;


    @PostMapping
    public boolean addProduct(@RequestBody @Valid Product p) {
       return databaseAccess.store(p);
    }

    @GetMapping
    public List<Product> getAll() {
        return databaseAccess.getSorted(Sort.id);
    }

    @GetMapping(value = "/{command}")
    public List<Product> sortBy(@PathVariable String command) {
        return databaseAccess.getSorted(Sort.valueOf(command));
    }


    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method=RequestMethod.DELETE)
    public String deleteById(@PathVariable String id) {
        return databaseAccess.deleteProductById(Integer.parseInt(id)).toString() + " removed";
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method = RequestMethod.PATCH)
    public String updateById(@PathVariable String id, @RequestBody @Valid Product p) {
        return "was updated to: \r\n"
                + databaseAccess.updateById(Integer.parseInt(id),p).toString();
    }


}
