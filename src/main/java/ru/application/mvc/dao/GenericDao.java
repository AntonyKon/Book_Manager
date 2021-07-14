package ru.application.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.application.mvc.models.Book;

import java.util.List;

public abstract class GenericDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract T findById(int id);
    public abstract T findByName(String name);
    public abstract List<T> findAll();
    public abstract void save(T model);
    public abstract void update(T model);
    public abstract void delete(T model);
}
