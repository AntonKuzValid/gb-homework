package ru.geekbrains.webstore.entity;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "details")
@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "total_cost")
    private Integer total_cost;

    @Column(name = "goods_list")
    private String goods_list;


}