package ru.application.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public abstract T findById(int id);
    public abstract T findByName(String name);
    public abstract List<T> findAll();
    public abstract void update(T model);
    public abstract void delete(T model);
}
