package com.example.spring_boot.repository;

import com.example.spring_boot.model.Products;
import com.example.spring_boot.service.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private static SessionFactory factory;

    public ProductRepository() {
        PrepareDataApp.forcePrepareData();
    }

    private void prepareFactory() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public void show() {
        prepareFactory();
        System.out.println("ProductRepository");
        try (Session session = factory.getCurrentSession()) {
            try {
                System.out.println("!  try  !");
                session.beginTransaction();
                final Products product = new Products(null, "Mandarin", "Fruits", 7);
                session.save(product);
                session.getTransaction().commit();
            } catch (Exception exception){
                System.out.println("!  catch  ! - " + exception);
                session.getTransaction().rollback();
            }
        } finally {
            System.out.println("!  finally  !");
            shutdown();
        }
    }

    public static void shutdown() {
        factory.close();
    }
}
