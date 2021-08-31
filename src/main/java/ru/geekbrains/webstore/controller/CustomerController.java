package ru.geekbrains.webstore.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webstore.dao.CustomerDao;
import ru.geekbrains.webstore.entity.Customer;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Customer getCustomer(@PathVariable String id) {
        return customerDao.getCustomer(Integer.parseInt(id));
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @PostMapping
    public boolean addCustomer(@RequestBody Customer c) {
        return customerDao.addCustomer(c);
    }

    @PatchMapping
    public boolean updateCustomer(@RequestBody Customer c) {
        return customerDao.updateCustomer(c);
    }

    @RequestMapping(
            value = "/{id}",
            produces = "application/json",
            method = RequestMethod.DELETE)
    public boolean deleteProduct(@PathVariable String id) {
        return customerDao.deleteCustomer(Integer.parseInt(id));
    }

}
