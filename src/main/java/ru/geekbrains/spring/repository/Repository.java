package ru.geekbrains.spring.repository;

import java.util.List;

public interface Repository<T> {

    List<T> getAll();

    T getById(Integer id);

    boolean add(T t);

    boolean deleteById(Integer id);

    boolean update(T t, Integer id);
}
