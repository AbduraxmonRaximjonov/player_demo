package uz.geeks.player_app.dao;


import org.hibernate.Session;
import uz.geeks.player_app.configs.HibernateConfigurer;
import uz.geeks.player_app.domains.Uploads;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UploadsDao implements Dao<Uploads> {
    @Override
    public Uploads create(Uploads entity) {
        Session session = HibernateConfigurer.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateConfigurer.getSession();
        session.getTransaction().begin();
        Uploads uploads = session.find(Uploads.class, id);
        if (Objects.nonNull(uploads))
            session.remove(uploads);
        session.getTransaction().commit();
    }

    @Override
    public List<Uploads> findAll() {
        Session session = HibernateConfigurer.getSession();
        return session.createQuery("select T from Uploads T order by T.id desc ", Uploads.class).getResultList();
    }

    @Override
    public Uploads findOne(Long id) {
        return null;
    }

    public Optional<Uploads> findByGeneratedName(String filename) {
        Session session = HibernateConfigurer.getSession();
        return Optional.ofNullable(
                session.createQuery("select t from Uploads t where t.generatedName = :generatedName", Uploads.class)
                        .setParameter("generatedName", filename)
                        .getSingleResultOrNull());
    }
}
