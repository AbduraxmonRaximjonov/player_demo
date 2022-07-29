package uz.geeks.player_app.dao;

import org.hibernate.Session;
import uz.jl.java_ee.configs.HibernateConfigurer;
import uz.jl.java_ee.domains.AuthUser;
import uz.jl.java_ee.service.AuthUserService;

import java.util.List;
import java.util.Optional;

public class AuthUserDao implements Dao<AuthUser> {
    @Override
    public AuthUser create(AuthUser entity) {
        Session session = HibernateConfigurer.getSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AuthUser> findAll() {
        return null;
    }

    @Override
    public AuthUser findOne(Long id) {
        return null;
    }

    public Optional<AuthUser> findByUsername(String username) {
        Session session = HibernateConfigurer.getSession();
        return Optional.ofNullable(
                session.createQuery("select  t from AuthUser t where t.username = :username", AuthUser.class)
                        .setParameter("username", username)
                        .getSingleResultOrNull());
    }
}
