package uz.geeks.player_app.dao;

import org.hibernate.Session;
import uz.geeks.player_app.configs.HibernateConfigurer;
import uz.geeks.player_app.domains.MusicPlayer;

import java.util.List;
import java.util.Objects;

public class MusicPlayerDao implements Dao<MusicPlayer>{
    private static MusicPlayerDao instance;

    public static MusicPlayerDao getInstance() {
        if (instance == null) {
            instance = new MusicPlayerDao();
        }
        return instance;
    }
    @Override
    public MusicPlayer create(MusicPlayer entity) {
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
        MusicPlayer musicPlayer = session.find(MusicPlayer.class, id);
        if (Objects.nonNull(musicPlayer))
            session.remove(musicPlayer);
        session.getTransaction().commit();
    }

    @Override
    public List<MusicPlayer> findAll() {
        Session session = HibernateConfigurer.getSession();
        return session.createQuery("select T from MusicPlayer T order by T.id desc ", MusicPlayer.class).getResultList();
    }

    @Override
    public MusicPlayer findOne(Long id) {
        return null;
    }


    public static void updateCoverId(long musicPlayerId, Long coverId) {
        Session session = HibernateConfigurer.getSession();
        session.getTransaction().begin();
        session.createNativeQuery("update MusicPlayer set cover_id = :cover_id where id = :id returning id", Long.class)
                .setParameter("id", musicPlayerId)
                .setParameter("cover_id", coverId)
                .getSingleResultOrNull();
        session.getTransaction().commit();
    }
}
