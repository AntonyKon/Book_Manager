package ru.application.mvc.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.application.mvc.models.Book;
import ru.application.mvc.models.Genre;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BookDao extends GenericDao<Book> {
    @Override
    public Book findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Book> query = session.createQuery(
                "from Book as book where book.id=:id", Book.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Book> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Book> query = session.createQuery(
                "from Book as book where book.name=:name", Book.class).setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Book> query = session.createQuery("from Book", Book.class);

        return query.getResultList();
    }

    @Override
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void delete(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
    }

    public List<Book> findByGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Book> query = session.createQuery(
                "from Book as book where book.genre=:genre", Book.class).setParameter("genre", genre);

        return query.getResultList();
    }

}
