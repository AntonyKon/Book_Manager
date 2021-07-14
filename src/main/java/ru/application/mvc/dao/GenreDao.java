package ru.application.mvc.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.application.mvc.models.Book;
import ru.application.mvc.models.Genre;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreDao extends GenericDao<Genre> {
    @Override
    public Genre findById(int id) {
        return null;
    }

    @Override
    public Genre findByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<Genre> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Genre> query = session.createQuery("from Genre", Genre.class);

        return query.getResultList();
    }

    @Override
    public void save(Genre model) {

    }

    @Override
    public void update(Genre model) {

    }

    @Override
    public void delete(Genre model) {

    }
}
