package com.example.spring_boot.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "trade_company")
    private String trade_company;

    @Column(name = "price")
    private Integer price;

    public Products(){}

    public Products(Integer id, String title, String trade_company, Integer price) {
        this.id = id;
        this.title = title;
        this.trade_company = trade_company;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return trade_company;
    }

    public void setCompany(String my_company) {
        this.trade_company = my_company;
    }

    public Integer getCost() {
        return price;
    }

    public void setCost(Integer price) {
        this.price = price;
    }

//    @Override
//    public String toString() {
//        return String.format("Products [id = %d, title = %s, trade_company = %s, price = %d]", id, title, trade_company, price);
//    }
}
