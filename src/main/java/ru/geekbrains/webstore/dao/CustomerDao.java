package ru.geekbrains.webstore.dao;


import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.webstore.entity.Customer;
import ru.geekbrains.webstore.entity.Product;
import ru.geekbrains.webstore.service.SessionFactoryService;

import java.util.List;

@Repository
@Log4j2
public class CustomerDao {

    @Autowired
    private SessionFactoryService service;

    private Session s;

    public boolean addCustomer(Customer c) {
         return service.add(c);
    }

    public List<Customer> getAll() {
        return service.getAllProduct("findAllC", Customer.class);
    }

    public Customer getCustomer(Integer id) {
        return service.get(id, "findC", Customer.class);
    }

    public boolean updateCustomer(Customer c) {
        return service.update(c);
    }

    public boolean deleteCustomer(Integer id) {
        return service.delete(id, "findC", Customer.class);
    }
}
