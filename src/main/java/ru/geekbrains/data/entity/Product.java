package ru.geekbrains.data.entity;


import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(schema = "public")
@ApiModel
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private BigDecimal cost;

    @Version
    @Column(name = "optlock",
            columnDefinition = "integer DEFAULT 0",
            nullable = false,
            length = 10)
    private Integer optlock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group")
    @JsonProperty("group")
    @ToString.Exclude
    private CostGroup group;


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
