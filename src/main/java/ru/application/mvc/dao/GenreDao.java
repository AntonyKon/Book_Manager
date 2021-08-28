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
public class GenreDao extends GenericDao<Genre> {
    @Override
    public Genre findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Genre> query = session.createQuery(
                "from Genre as genre where genre.id=:id", Genre.class).setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Genre> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Genre> query = session.createQuery(
                "from Genre as genre where genre.name=:name", Genre.class).setParameter("name", name);

        return query.getResultList();
    }

    @Override
    public List<Genre> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Genre> query = session.createQuery("from Genre", Genre.class);

        return query.getResultList();
    }

    @Override
    public void save(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.save(genre);
    }

    @Override
    public void update(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.update(genre);
    }

    @Override
    public void delete(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(genre);
    }
}
