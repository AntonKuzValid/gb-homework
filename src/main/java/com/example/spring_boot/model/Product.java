package com.example.spring_boot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Getter @Setter
@Table(name = "product", schema = "lesson5")
public class Product {

    @Id
    @NotNull
    @Column(name = "id", updatable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "company")
    private String company;

    @Column(name = "cost")
    private Integer cost;

    public Product(){}

    public Product(Long id, String title, String company, Integer cost) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Products [id = %d, title = %s, company = %s, cost = %s]", id, title, company, cost);
    }
}
