package ru.geekbrains.spring.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "public")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "from Product"),
        @NamedQuery(name = "getById", query = "from Product where id = :id")
})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "company")
    private String company;
    @Version
    @Column(name = "optlock",
            columnDefinition = "integer DEFAULT 0",
            nullable = false,
            length = 10)
    private Integer optlock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && title.equals(product.title) && cost.equals(product.cost) && company.equals(product.company);
    }

    @Override
    public int hashCode() {
        return 2042274511;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
