package dao.SQLite.interfaces;

import entity.Sub_service;

import java.sql.SQLException;
import java.util.List;

public interface Sub_serviceDAO extends GenericDAO<Sub_service>{

    Sub_service findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException;//так как связь многие ко многим

}
