package ru.geekbrains.webstore.dao;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.webstore.entity.Product;
import ru.geekbrains.webstore.service.SessionFactoryService;

import java.util.List;

@Repository
@Log4j2
public class ProductDao {

    @Autowired
    private SessionFactoryService service;

    private Session s;

    public Product getProduct(Integer id) {
        return service.get(id, "findP", Product.class);
    }

    public List<Product> getAllProduct() {
        return service.getAllProduct("findAllP", Product.class);
    }

    public boolean addProduct(Product p) {
        return service.add(p);
    }


    public boolean deleteProduct(Integer id) {
        return service.delete(id, "findP", Product.class);
    }

    public boolean updateProduct(Product p) {
        return service.update(p);
    }
}
