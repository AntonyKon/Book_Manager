package ru.application.mvc.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.application.mvc.models.Country;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CountryDao extends GenericDao<Country> {

    @Override
    public Country findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Country> query = session.createQuery(
                "from Country as country where country.id=:id", Country.class).setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<Country> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Country> query = session.createQuery(
                "from Country as country where country.name like :name", Country.class).setParameter("name", name+"%");

        return query.getResultList();
    }

    @Override
    public List<Country> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Country> query = session.createQuery("from Country", Country.class);

        return query.getResultList();
    }

    @Override
    public int save(Country country) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(country);
    }

    @Override
    public void update(Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.update(country);
    }

    @Override
    public void delete(Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(country);
    }
}
