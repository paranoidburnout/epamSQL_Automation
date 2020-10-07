package service;

import dao.SQLite.implementations.AbonentDaoImpl;
import dao.SQLite.interfaces.AbonentDAO;
import entity.Abonent;

import java.sql.SQLException;
import java.util.List;

public class AbonentService {
    private AbonentDAO abonentDAO;

    public AbonentService(){
        this.abonentDAO= new AbonentDaoImpl();
    }

    public Abonent findById(int id) throws SQLException {
        return abonentDAO.findById(id);
    }
    public List<Abonent> findAll() throws SQLException {
        return abonentDAO.findAll();
    }

    public void delete(int id) throws SQLException {
        abonentDAO.delete(id);
    }
    public void create(Abonent abonent) throws SQLException{
        abonentDAO.create(abonent);
    }
    public void update(Abonent abonent) throws SQLException{
        abonentDAO.update(abonent);
    }

}