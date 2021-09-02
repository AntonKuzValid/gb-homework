package com.example.spring_boot.repository;

import com.example.spring_boot.model.Product;
import com.example.spring_boot.service.PrepareDataApp;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private static SessionFactory factory;

    private void prepareFactory() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public List<Product> selectAll() {
        prepareFactory();
        List<Product> items = new CopyOnWriteArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                items = session.createQuery("from Product").getResultList();
                session.getTransaction().commit();
            } catch (Exception exception){
                session.getTransaction().rollback();
            }
        } finally {
            factory.close();
        }
        return items;
    }

    public void removeFromDB(Long id) {
        prepareFactory();
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                Product product = selectAll().get(id.intValue());
                session.delete(new Product(null, product.getTitle(), product.getCompany(), product.getCost()));
                session.getTransaction().commit();
            } catch (Exception exception){
                System.out.println("\n\n ! RemoveFromDB  catch  ! - " + exception + "\n\n");
                session.getTransaction().rollback();
            }
        } finally {
            factory.close();
        }
    }
}
