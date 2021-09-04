package ru.geekbrains.data.repository.spec;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.data.entity.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@UtilityClass
public class ProductSpec {

    public static Specification<Product> getFiltered(Filter filter) {
        return (root, query, criteriaBuilder) -> getPredicate(criteriaBuilder, root, filter);
    }

    private Predicate getPredicate(CriteriaBuilder cb, Root<Product> root, Filter f) {
        return switch (f.getC()) {
            case GTM -> cb.greaterThan(root.get("cost"), f.getMin());
            case LTM -> cb.lessThan(root.get("cost"), f.getMax());
            default -> cb.between(root.get("cost"), f.getMin(), f.getMax());
        };
    }
}
