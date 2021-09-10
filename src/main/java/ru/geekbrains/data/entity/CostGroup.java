package ru.geekbrains.data.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(schema = "public", name = "cost_group")
public class CostGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "costgroup", nullable = false)
    private Long costGroup;

    @Column(name = "title")
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CostGroup costGroup = (CostGroup) o;

        return Objects.equals(id, costGroup.id);
    }

    @Override
    public int hashCode() {
        return 820057669;
    }
}
