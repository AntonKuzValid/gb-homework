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
@org.hibernate.annotations.NamedQuery(name = "findP", query = "from Product where id = :id")
@org.hibernate.annotations.NamedQuery(name = "findAllP", query = "from Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private String cost;

    @Version
    @Column(name = "optlock",
            columnDefinition = "integer DEFAULT 0",
            nullable = false,
            length = 10)
    private Integer optlock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return 2042274511;
    }
}
