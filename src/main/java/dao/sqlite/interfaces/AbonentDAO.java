package dao.sqlite.interfaces;

import entity.Abonent;

import java.sql.SQLException;
import java.util.List;

public interface AbonentDAO extends GenericDAO<Abonent> {
    @Override
    void create(Abonent entity) throws SQLException;

    @Override
    void update(Abonent entity) throws SQLException;

    @Override
    void delete(Abonent entity) throws SQLException;

    @Override
    void deleteById(int id) throws SQLException;

    @Override
    Abonent findById(int id) throws SQLException;

    @Override
    List<Abonent> findAll() throws SQLException;
}
