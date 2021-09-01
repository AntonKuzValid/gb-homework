package ru.geekbrains.webstore.service;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import ru.geekbrains.webstore.entity.Ordering;

import java.util.List;

/**
 * Задание
 * 1. В базе данных необходимо реализовать возможность хранить
 * информацию о покупателях (id, имя) и товарах (id, название, стоимость). +++
 * У каждого покупателя свой набор купленных товаров; +++
 * 2. Для обеих сущностей создаете Dao классы. +++
 * Работу с SessionFactory выносите во вспомогательный класс; +++
 * 3. * Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров, и по id товара узнавать список покупателей этого товара;
 * 4. ** Добавить детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом;
 */


@Service
@Log4j2
public class SessionFactoryService {

    private SessionFactory factory;

    private Session s;

    public SessionFactoryService() {
        try {
            factory = new Configuration()
                    .configure("service/hibernate.cfg.xml")
                    .buildSessionFactory();
            log.debug("Session factory created");
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void close() {
        factory.close();
    }

    public <T> boolean add(T t) {
        try {
            s = getSession();
            s.beginTransaction();
            s.save(t);
            log.info("Save " + t);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.info(e.getMessage() + e.getCause());
            return false;
        }
    }

    public <T> List<T> getAllProduct(String q, Class<T> tClass) {
        try {
            s = getSession();
            s.beginTransaction();
            return s.createNamedQuery(q, tClass).getResultList();
        } catch (Exception e) {
            log.info(e.getMessage() + e.getCause());
            return null;
        }
    }

    public <T> T get(Integer id, String q, Class<T> tClass) {
        try {
            s = getSession();
            s.beginTransaction();
            return s
                    .createNamedQuery(q, tClass)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            log.info(e.getMessage() + e.getCause());
            return null;
        } finally {
            s.getTransaction().commit();
        }
    }

    public <T> boolean update(T t) {
        try {
            s = getSession();
            s.beginTransaction();
            s.update(t);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.info(e.getMessage() + e.getCause());
            return false;
        }
    }

    public <T> boolean delete(Integer id, String q, Class<T> tClass) {
        try {
            s = getSession();
            s.beginTransaction();
            T t = s
                    .createNamedQuery(q, tClass)
                    .setParameter("id", id).getSingleResult();
            s.delete(t);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.info(e.getMessage() + e.getCause());
            return false;
        }
    }
}
