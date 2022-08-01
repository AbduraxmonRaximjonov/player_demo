package uz.geeks.player_app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.geeks.player_app.configs.HibernateConfigurer;
import uz.geeks.player_app.domains.Cover;
import uz.geeks.player_app.domains.Uploads;

import java.util.List;
import java.util.Optional;

public class FileStorageDao implements Dao<Uploads> {

    private static final SessionFactory sessionFactory = HibernateConfigurer.getSessionFactory();
    private static FileStorageDao instance;

    public static FileStorageDao getInstance() {
        if (instance == null) {
            instance = new FileStorageDao();
        }
        return instance;
    }
    @Override
    public Uploads create(Uploads entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public Cover create(Cover entity) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Uploads> findAll() {
        return null;
    }

    @Override
    public Uploads findOne(Long id) {
        return null;
    }

    public Optional<Uploads> getOneTemplateCover() {
        Session session = HibernateConfigurer.getSession();
        return Optional.ofNullable(session
                .createQuery("select t from Uploads t where t.template", Uploads.class)
                .getSingleResultOrNull());
    }

}
