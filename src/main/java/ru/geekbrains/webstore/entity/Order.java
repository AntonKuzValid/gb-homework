package ru.geekbrains.webstore.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @ManyToOne
    @JoinColumn(name = "order_details")
    private Details order_details;

    @Version
    @Column(name = "optlock",
            columnDefinition = "integer DEFAULT 0",
            nullable = false,
            length = 10
    )
    private Integer optlock;

}


