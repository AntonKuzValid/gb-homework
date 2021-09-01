package ru.geekbrains.webstore.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.NamedQuery(name = "findOrdersByName", query = "from Ordering where customer = :customer")
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customer")
    private Integer customer;

    @Column(name = "product")
    private Integer product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productcost")
    private Integer productCost;

    @Column(name = "totalcost")
    private Integer totalCost;

    @Column(name = "date")
    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ordering ordering = (Ordering) o;

        return Objects.equals(id, ordering.id);
    }

    @Override
    public int hashCode() {
        return 737800560;
    }
}
