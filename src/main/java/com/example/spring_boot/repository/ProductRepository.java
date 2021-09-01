package com.example.spring_boot.repository;

import com.example.spring_boot.model.Products;
import com.example.spring_boot.service.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    public List<Products> selectAll() {
        prepareFactory();
        List<Products> items = new CopyOnWriteArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                items = session.createQuery("from Products").getResultList();
                System.out.println(items + "\n");

                session.getTransaction().commit();
            } catch (Exception exception){
                session.getTransaction().rollback();
            }
        } finally {
            shutdown();
        }
        return items;
    }

    public static void shutdown() {
        factory.close();
    }

    public void removeFromDB(Integer id) {
        System.out.println("remove - " + id);
        prepareFactory();
        try (Session session = factory.getCurrentSession()) {
            try {
                System.out.println("!  try  !");
                session.beginTransaction();
                Products products = session.get(Products.class, id);
                System.out.println(products.toString());
                session.delete(products);
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
}
