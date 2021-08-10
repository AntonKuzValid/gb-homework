package com.springgb.gbwebservlet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.UUID;

public class Product {
    private String id;
    private String title;
    private Double cost;
    double minCost = 10;
    double maxCost = 100;
    Random r = new Random();


    public Product(String title) {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,8);
        this.title = title;
        double randomDouble = minCost + (maxCost - minCost) * r.nextDouble();
        BigDecimal db = new BigDecimal(randomDouble).setScale(2, RoundingMode.HALF_UP);
        this.cost = db.doubleValue();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getCost() {
        return cost;
    }
}
