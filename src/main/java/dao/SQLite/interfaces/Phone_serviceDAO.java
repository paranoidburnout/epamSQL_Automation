package dao.SQLite.interfaces;

import entity.Phone_service;

import java.sql.SQLException;
import java.util.List;

public interface Phone_serviceDAO extends GenericDAO<Phone_service>{
    @Override
    void create(Phone_service entity) throws SQLException;

    @Override
    void update(Phone_service entity) throws SQLException;

    @Override
    void delete(int id) throws SQLException;

    @Override
    void delete(Phone_service entity) throws SQLException;

    @Override
    Phone_service findById(int id) throws SQLException;

    @Override
    List<Phone_service> findAll() throws SQLException;
}
