package dao.sqlite.interfaces;

import entity.SubService;

import java.sql.SQLException;
import java.util.List;

public interface SubServiceDAO extends GenericDAO<SubService> {
    SubService findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException;//так как связь многие ко многим

    SubService findByAbonentId(int Abonent_id) throws SQLException;

    SubService findByPhoneServiceId(int Phone_service_id) throws SQLException;

    @Override
    void create(SubService sub_service) throws SQLException;

    @Override
    void update(SubService entity) throws SQLException;

    @Override
    void delete(SubService entity) throws SQLException;

    @Override
    List<SubService> findAll() throws SQLException;
}
