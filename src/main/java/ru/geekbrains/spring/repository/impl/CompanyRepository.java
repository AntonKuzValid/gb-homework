package ru.geekbrains.spring.repository.impl;

import ru.geekbrains.spring.repository.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@org.springframework.stereotype.Repository
public class CompanyRepository implements Repository<String> {

    private final List<String> rep;

    public CompanyRepository() {
        rep = new CopyOnWriteArrayList<>();
        rep.add("Молоко от дяди Вани");
        rep.add("Апельсины от обезьяны");
        rep.add("Apple");
    }

    @Override
    public List<String> getAll() {
        return rep.stream().toList();
    }

    @Override
    public String getById(Integer id) {
        return rep.get(id);
    }

    @Override
    public boolean add(String s) {
        return rep.add(s);
    }

    @Override
    public boolean deleteById(Integer id) {
        return rep.remove(getById(id));
    }

    @Override
    public boolean update(String s, Integer id) {
        return false;
    }
}
