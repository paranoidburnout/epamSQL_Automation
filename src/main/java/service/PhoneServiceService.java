package service;

import dao.sqlite.implementations.PhoneServiceDaoImpl;
import dao.sqlite.interfaces.PhoneServiceDAO;
import entity.PhoneService;

import java.sql.SQLException;
import java.util.List;

public class PhoneServiceService {
    private PhoneServiceDAO phone_serviceDAO;

    public PhoneServiceService() {
        this.phone_serviceDAO = new PhoneServiceDaoImpl();
    }

    public PhoneService findById(int id) throws SQLException {
        return phone_serviceDAO.findById(id);
    }

    public List<PhoneService> findAll() throws SQLException {
        return phone_serviceDAO.findAll();
    }

    public void delete(int id) throws SQLException {
        phone_serviceDAO.deleteById(id);
    }

    public void create(PhoneService phone_service) throws SQLException {
        phone_serviceDAO.create(phone_service);
    }

    public void update(PhoneService phone_service) throws SQLException {
        phone_serviceDAO.update(phone_service);
    }

}
