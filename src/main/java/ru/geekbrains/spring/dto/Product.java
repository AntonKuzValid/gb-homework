package ru.geekbrains.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    int id;
    double cost;
    String title;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                '}';
    }
}
