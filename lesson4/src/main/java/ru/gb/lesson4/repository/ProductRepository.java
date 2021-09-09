package ru.gb.lesson4.repository;

import org.springframework.web.bind.annotation.RestController;
import ru.gb.lesson4.model.Product;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class ProductRepository {
    private List<Product> productList = new CopyOnWriteArrayList<>();
        private AtomicInteger conter = new AtomicInteger();

    public List<Product> findAll() {
        return productList.stream().collect(Collectors.toList());
    }

    public void save(Product product) {
        product.setId(conter.incrementAndGet());
        productList.add(product);
    }

    public void deleteById(Integer id) {
        productList.removeIf(it -> it.getId().equals(id));
    }

}
