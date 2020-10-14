package service;

import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;

import java.sql.SQLException;
import java.util.List;

public class AbonentService {
    private AbonentDAO abonentDAO;

    public AbonentService() {
        this.abonentDAO = new AbonentDaoImpl();
    }

    public Abonent findById(int id) throws SQLException {
        return abonentDAO.findById(id);
    }

    public List<Abonent> findAll() throws SQLException {
        return abonentDAO.findAll();
    }

    public void create(Abonent abonent) throws Exception, SQLException {
        abonentDAO.create(abonent);
    }

    public void update(Abonent abonent) throws Exception, SQLException {
        abonentDAO.update(abonent);
    }

    public void delete(int id) throws SQLException {
        abonentDAO.deleteById(id);
    }
    public Abonent findForSecondName(String second_name) throws Exception {
        return abonentDAO.findForSecondName(second_name);
    }
    public Abonent findForFirstName(String first_name) throws Exception {
        return abonentDAO.findForFirstName(first_name);
    }
    public Abonent findForPhoneNumber(String phone_number) throws Exception{
        return abonentDAO.findForPhoneNumber(phone_number);
    }
}
