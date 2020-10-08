package service;

import dao.sqlite.implementations.Sub_serviceDaoImpl;
import dao.sqlite.interfaces.Sub_serviceDAO;
import entity.Sub_service;

import java.sql.SQLException;
import java.util.List;

public class Sub_serviceService {
    private Sub_serviceDAO sub_serviceDAO;

    public Sub_serviceService() {
        this.sub_serviceDAO = new Sub_serviceDaoImpl();
    }

    public Sub_service findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException {
        return sub_serviceDAO.findByAbonent_idAndPhone_service_id(Abonent_id, Phone_service_id);
    }

    public List<Sub_service> findAll() throws SQLException {
        return sub_serviceDAO.findAll();
    }

    public void delete(Sub_service sub_service) throws SQLException {
        sub_serviceDAO.delete(sub_service);
    }

    public void create(Sub_service sub_service) throws SQLException {
        sub_serviceDAO.create(sub_service);
    }

    public void update(Sub_service sub_service) throws SQLException {
        sub_serviceDAO.update(sub_service);
    }

}
