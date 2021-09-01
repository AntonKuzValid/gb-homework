package ru.geekbrains.webstore.dao;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.webstore.entity.Customer;
import ru.geekbrains.webstore.entity.Ordering;
import ru.geekbrains.webstore.entity.Product;
import ru.geekbrains.webstore.service.SessionFactoryService;

import java.util.Date;
import java.util.List;

@Repository
@Log4j2
public class CustomerDao {

    @Autowired
    private SessionFactoryService service;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ObjectMapper objectMapper;

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

    public boolean addOrder(Ordering o) {
        o.setDate(new Date());

        Product p = productDao.getProduct(o.getProduct());
        o.setProductCost(Integer.parseInt(p.getCost()));
        o.setTotalCost(o.getProductCost() * o.getQuantity());

        return service.add(o);
    }

    public List<Ordering> getOrders(String name) {
        Session s = service.getSession();
        s.beginTransaction();
        try {
            JsonNode node = objectMapper.readTree(name);
            Customer c = s
                    .createNamedQuery("findByName", Customer.class)
                    .setParameter("name", node.get("name").asText())
                    .getSingleResult();

            return s.createNamedQuery("findOrdersByName", Ordering.class)
                    .setParameter("customer", c.getId())
                    .getResultList();
        } catch (NullPointerException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
