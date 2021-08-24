package ru.geekbrains.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.geekbrains.spring.annotation.Company;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private Integer cost;
    @Company
    private String company;
}
