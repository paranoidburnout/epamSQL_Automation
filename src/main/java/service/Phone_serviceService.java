package service;


import dao.sqlite.implementations.Phone_serviceDaoImpl;
import dao.sqlite.interfaces.Phone_serviceDAO;
import entity.Phone_service;

import java.sql.SQLException;
import java.util.List;

public class Phone_serviceService {
    private Phone_serviceDAO phone_serviceDAO;

    public Phone_serviceService(){
        this.phone_serviceDAO= new Phone_serviceDaoImpl();
    }

    public Phone_service findById(int id) throws SQLException {
        return phone_serviceDAO.findById(id);
    }
    public List<Phone_service> findAll() throws SQLException {
        return phone_serviceDAO.findAll();
    }

    public void delete(int id) throws SQLException {
        phone_serviceDAO.deleteById(id);
    }
    public void create(Phone_service phone_service) throws SQLException{
        phone_serviceDAO.create(phone_service);
    }
    public void update(Phone_service phone_service) throws SQLException{
        phone_serviceDAO.update(phone_service);
    }

}
