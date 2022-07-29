package uz.geeks.player_app.dao;

import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 26/07/22/11:51 (Tuesday)
 * java-ee/IntelliJ IDEA
 */
public interface Dao<T> {
    T create(T entity);

    void delete(Long id);

    List<T> findAll();

    T findOne(Long id);

}
