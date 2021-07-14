package ru.application.mvc.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.application.mvc.models.Book;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDao extends GenericDao<Book> {
    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Book findByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Book> query = session.createQuery("from Book", Book.class);

        return query.getResultList();
    }

    @Override
    public void save(Book book) {
    }

    @Override
    public void update(Book book) {
    }

    @Override
    public void delete(Book book) {

    }
}
