package ru.application.mvc.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.application.mvc.models.Author;

import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AuthorDao extends GenericDao<Author> {
    @Resource(mappedName = "fileStorage/basePath")
    private String path;

    @Override
    public Author findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Author> query = session.createQuery("from Author as author where author.id=:id", Author.class).setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Author> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Author> query = session.createQuery("from Author as author where author.name like :name", Author.class).setParameter("name", name+"%");

        return query.getResultList();
    }

    @Override
    public List<Author> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Author> query = session.createQuery("from Author", Author.class);

        return query.getResultList();
    }

    @Override
    public int save(Author author) {
        Session session = sessionFactory.getCurrentSession();

        return (Integer) session.save(author);
    }

    @Override
    public void update(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.update(author);
    }

    @Override
    public void delete(Author author) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(author);
    }

    public String getPath() {
        return path;
    }
}
