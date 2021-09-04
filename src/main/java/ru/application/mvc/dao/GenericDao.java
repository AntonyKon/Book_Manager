package ru.application.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class GenericDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract T findById(int id);
    public abstract List<T> findByName(String name);
    public abstract List<T> findAll();
    public abstract int save(T model);
    public abstract void update(T model);
    public abstract void delete(T model);
}
