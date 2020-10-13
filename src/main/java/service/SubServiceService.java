package service;

import dao.sqlite.implementations.SubServiceDaoImpl;
import dao.sqlite.interfaces.SubServiceDAO;
import entity.SubService;

import java.sql.SQLException;
import java.util.List;

public class SubServiceService {
    private SubServiceDAO sub_serviceDAO;

    public SubServiceService() {
        this.sub_serviceDAO = new SubServiceDaoImpl();
    }

    public SubService findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException {
        return sub_serviceDAO.findByAbonent_idAndPhone_service_id(Abonent_id, Phone_service_id);
    }

    public List<SubService> findAll() throws SQLException {
        return sub_serviceDAO.findAll();
    }

    public void delete(SubService sub_service) throws SQLException {
        sub_serviceDAO.delete(sub_service);
    }

    public void create(SubService sub_service) throws SQLException {
        sub_serviceDAO.create(sub_service);
    }

    public void update(SubService sub_service) throws SQLException {
        sub_serviceDAO.update(sub_service);
    }

    public SubService findByAbonentId(int Abonent_id) throws SQLException {
        return sub_serviceDAO.findByAbonentId(Abonent_id);
    }

    public SubService findByPhoneServiceId(int Phone_service_id) throws SQLException {
        return sub_serviceDAO.findByPhoneServiceId(Phone_service_id);
    }
}
