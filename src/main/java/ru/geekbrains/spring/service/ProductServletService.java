package ru.geekbrains.spring.service;

import ru.geekbrains.spring.dto.Product;

import java.util.Arrays;
import java.util.List;

public class ProductServletService {

    public List<Product> getTenProducts() {
        return Arrays.asList(new Product(1, 1.0, "Pencil"),
                new Product(2, 2.0, "Fish"),
                new Product(3, 3.0, "Cat"),
                new Product(4, 4.0, "Devil"),
                new Product(5, 5.0, "Angel"),
                new Product(6, 6.0, "Six demons of Amily Rose"),
                new Product(7, 7.0, "Seven birds"),
                new Product(8, 8.0, "Eight son"),
                new Product(9, 9.0, "Nine circles of hell"),
                new Product(10, 10.0, "I love Java"));
    }
}
