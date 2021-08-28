package ru.geekbrains.spring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.command.Sort;
import ru.geekbrains.spring.filter.Filter;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.repository.database.DatabaseAccess;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Log4j2
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
            method = RequestMethod.DELETE)
    public String deleteById(@PathVariable String id) {
        return databaseAccess.deleteProductById(Integer.parseInt(id)).toString() + " removed";
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method = RequestMethod.PATCH)
    public String updateById(@PathVariable String id, @RequestBody @Valid Product p) {
        return "Updated to: " + databaseAccess.updateById(Integer.parseInt(id), p);
    }

    @GetMapping(value = "/filter", produces = "application/json")
    public List<Product> getFiltered(@RequestBody @Valid Filter filter) {
        return databaseAccess.getFiltered(filter);
    }

    @ExceptionHandler({StaleObjectStateException.class})
    public ResponseEntity<Object> handleException(StaleObjectStateException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        return new ResponseEntity<>(details, HttpStatus.TOO_MANY_REQUESTS);
    }




}
