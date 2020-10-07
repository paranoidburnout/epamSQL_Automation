package dao.SQLite.implementations;

import dao.SQLite.interfaces.Phone_serviceDAO;
import dao.connection.DB;
import entity.Phone_service;

import java.sql.SQLException;
import java.util.List;

//public class Phone_serviceDaoImpl implements Phone_serviceDAO {
//    public Phone_serviceDaoImpl(Connection dao.connection) {
//
//    }
//
//    @Override
//    public List<Phone_service> getAllPhone_services() {
//        return null;
//    }
//
//    @Override
//    public Phone_service getPhone_service(int rollNo) {
//        return null;
//    }
//
//    @Override
//    public void updatePhone_service(Phone_service phone_service) {
//
//    }
//
//    @Override
//    public void deletePhone_service(Phone_service phone_service) {
//
//    }
//}
public class Phone_serviceDaoImpl extends DB implements Phone_serviceDAO {

    @Override
    public void create(Phone_service entity) throws SQLException {

    }

    @Override
    public void update(Phone_service entity) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void delete(Phone_service entity) throws SQLException {

    }

    @Override
    public Phone_service findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Phone_service> findAll() throws SQLException {
        return null;
    }
}