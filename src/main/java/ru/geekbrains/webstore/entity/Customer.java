package ru.geekbrains.webstore.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.NamedQuery(name = "findC", query = "from Customer where id = :id")
@org.hibernate.annotations.NamedQuery(name = "findAllC", query = "from Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;

        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return 339958611;
    }
}
