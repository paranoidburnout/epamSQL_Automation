package dao.SQLite.interfaces;

import entity.Sub_service;

import java.sql.SQLException;
import java.util.List;

public interface Sub_serviceDAO extends GenericDAO<Sub_service>{
//    //create
//    void create(Sub_service sub_service) throws SQLException;
//
//    //read
//    List<Sub_service> findAll() throws SQLException;

    Sub_service findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException;//так как связь многие ко многим

//    //update
//    void update(Sub_service sub_service) throws SQLException;
//
//    //remove
//    void delete(Sub_service sub_service) throws SQLException;
}
