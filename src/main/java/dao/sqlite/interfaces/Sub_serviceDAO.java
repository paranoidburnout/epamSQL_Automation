package dao.sqlite.interfaces;

import entity.Phone_service;
import entity.Sub_service;

import java.sql.SQLException;
import java.util.List;

public interface Sub_serviceDAO extends GenericDAO<Sub_service> {
    Sub_service findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException;//так как связь многие ко многим

    Sub_service findByAbonentId(int Abonent_id) throws SQLException;

    Sub_service findByPhoneServiceId(int Phone_service_id) throws SQLException;

    @Override
    void create(Sub_service sub_service) throws SQLException;

    @Override
    void update(Sub_service entity) throws SQLException;

    @Override
    void delete(Sub_service entity) throws SQLException;

    @Override
    List<Sub_service> findAll() throws SQLException;
}
