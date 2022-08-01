package uz.geeks.player_app.dao;

import org.hibernate.Session;
import uz.geeks.player_app.configs.HibernateConfigurer;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.domains.Uploads;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CoverDao implements Dao<Cover>{
    private static CoverDao instance;

    public static CoverDao getInstance() {
        if (instance == null) {
            instance = new CoverDao();
        }
        return instance;
    }
    @Override
    public Cover create(Cover entity) {
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
        Cover uploads = session.find(Cover.class, id);
        if (Objects.nonNull(uploads))
            session.remove(uploads);
        session.getTransaction().commit();
    }

    @Override
    public List<Cover> findAll() {
        Session session = HibernateConfigurer.getSession();
        return session.createQuery("select T from Cover T order by T.id desc ", Cover.class).getResultList();
    }

    @Override
    public Cover findOne(Long id) {
        return null;
    }

    public Optional<Cover> findByGeneratedName(String filename) {
        Session session = HibernateConfigurer.getSession();
        return Optional.ofNullable(
                session.createQuery("select t from Cover t where t.generatedName = :generatedName", Cover.class)
                        .setParameter("generatedName", filename)
                        .getSingleResultOrNull());
    }
}
