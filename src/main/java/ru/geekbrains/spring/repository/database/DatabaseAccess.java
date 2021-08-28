package ru.geekbrains.spring.repository.database;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.command.Operation;
import ru.geekbrains.spring.command.Sort;
import ru.geekbrains.spring.filter.Filter;
import ru.geekbrains.spring.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DatabaseAccess {


    @PersistenceContext
    private EntityManager entityManager;

    public Product getById(Integer id) {
        return entityManager
                .createNamedQuery("getById", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Product> getAll() {
        return entityManager
                .createNamedQuery("getAll", Product.class)
                .getResultList();
    }

    @Transactional
    public boolean store(Product p) {
        if (entityManager.isOpen()) {
            entityManager.persist(p);
            return true;
        }
        return false;
    }

    @Transactional
    public Product deleteProductById(Integer id) {
        Product p;
        if ((p = getById(id)) != null) {
            entityManager.lock(p, LockModeType.OPTIMISTIC);
            entityManager.remove(p);
        }
        return p;
    }

    @Transactional
    public String updateById(int id, Product p) {

        Product inRepository;
        if ((inRepository = getById(id)) != null) {
            entityManager.lock(inRepository, LockModeType.OPTIMISTIC);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            inRepository.setCompany(p.getCompany());
            inRepository.setTitle(p.getTitle());
            inRepository.setCost(p.getCost());
            entityManager.merge(inRepository);
        }
        return getById(id).toString();
    }

    public List<Product> getSorted(Sort s) {
        switch (s) {
            case id -> {
                return getAll().stream()
                        .sorted(Comparator.comparing(Product::getId))
                        .collect(Collectors.toList());
            }
            case title -> {
                return getAll().stream()
                        .sorted(Comparator.comparing(Product::getTitle))
                        .collect(Collectors.toList());
            }
            case cost -> {
                return getAll().stream()
                        .sorted(Comparator.comparing(Product::getCost))
                        .collect(Collectors.toList());
            }
            case company -> {
                return getAll().stream()
                        .sorted(Comparator.comparing(Product::getCompany))
                        .collect(Collectors.toList());
            }
        }
        return getAll();
    }

    public List<String> getColumnNames() {
        return entityManager.createNativeQuery("" +
                "select column_name " +
                "from information_schema.columns " +
                "where table_name = 'product'").getResultList();
    }

    /**
     * Filtered search
     * @param filter filter params
     * @return Filtered list
     */
    public List<Product> getFiltered(Filter filter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = cb.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        TypedQuery<Product> query;
        List<Product> results;
        Operation o = Operation.valueOf(filter.getOperation());

        Predicate greaterThen = cb.greaterThan(root.get(filter.getFieldName()), filter.getValue());
        Predicate lesserThen = cb.lessThan(root.get(filter.getFieldName()), filter.getValue());
        Predicate equals = cb.equal(root.get(filter.getFieldName()), filter.getValue());
        Predicate notEquals = cb.notEqual(root.get(filter.getFieldName()), filter.getValue());
        Predicate like = cb.like(root.get(filter.getFieldName()),'%'+filter.getValue()+'%');

        switch (o) {
            case GT -> criteriaQuery.select(root).where(cb.or(greaterThen)).orderBy(cb.desc(root.get(filter.getFieldName())));
            case LT -> criteriaQuery.select(root).where(cb.or(lesserThen)).orderBy(cb.desc(root.get(filter.getFieldName())));
            case EQ -> criteriaQuery.select(root).where(cb.or(equals)).orderBy(cb.desc(root.get(filter.getFieldName())));
            case NEQ -> criteriaQuery.select(root).where(cb.or(notEquals)).orderBy(cb.desc(root.get(filter.getFieldName())));
            case LI -> criteriaQuery.select(root).where(cb.or(like)).orderBy(cb.desc(root.get(filter.getFieldName())));
        }

        query = entityManager.createQuery(criteriaQuery);
        results = query.getResultList();
        System.out.println(results);
        return null;
    }
}
