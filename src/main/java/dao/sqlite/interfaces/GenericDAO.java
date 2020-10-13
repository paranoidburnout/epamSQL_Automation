package dao.sqlite.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    void create(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(T entity) throws SQLException;

    void deleteById(int id) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

}