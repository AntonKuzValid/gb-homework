package com.example.spring_boot;

import com.example.spring_boot.service.PrepareDataApp;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {
    private static SessionFactory factory;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);

        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
