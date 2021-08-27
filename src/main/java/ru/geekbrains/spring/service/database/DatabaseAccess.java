package ru.geekbrains.spring.service.database;

import org.springframework.stereotype.Service;
import ru.geekbrains.spring.command.Sort;
import ru.geekbrains.spring.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseAccess {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product getById(Integer id) {
        return entityManager
                .createNamedQuery("getById", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
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
            entityManager.remove(p);
        }
        return p;
    }

    @Transactional
    public Product updateById(int id, Product p) {
        Product inRepository;
        if ((inRepository = getById(id)) != null) {
            inRepository.setCompany(p.getCompany());
            inRepository.setTitle(p.getTitle());
            inRepository.setCost(p.getCost());
            entityManager.merge(inRepository);
        }
        return getById(id);
    }

    @Transactional
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
}
