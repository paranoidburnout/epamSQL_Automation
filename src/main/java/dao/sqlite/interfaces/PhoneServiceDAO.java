package dao.sqlite.interfaces;

import entity.PhoneService;

import java.sql.SQLException;
import java.util.List;

public interface PhoneServiceDAO extends GenericDAO<PhoneService> {
    @Override
    void create(PhoneService entity) throws SQLException;

    @Override
    void update(PhoneService entity) throws SQLException;

    @Override
    void deleteById(int id) throws SQLException;

    @Override
    void delete(PhoneService entity) throws SQLException;

    @Override
    PhoneService findById(int id) throws SQLException;

    @Override
    List<PhoneService> findAll() throws SQLException;
}
