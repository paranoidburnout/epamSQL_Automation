package dao.sqlite.interfaces;

import entity.Abonent;

import java.sql.SQLException;
import java.util.List;

public interface AbonentDAO extends GenericDAO<Abonent> {
    @Override
    void create(Abonent entity) throws Exception;

    @Override
    void update(Abonent entity) throws Exception;

    @Override
    void delete(Abonent entity) throws Exception;

    @Override
    void deleteById(int id) throws SQLException;

    @Override
    Abonent findById(int id) throws SQLException;

    @Override
    List<Abonent> findAll() throws SQLException;

    Abonent findForSecondName(String second_name) throws SQLException;

    Abonent findForFirstName(String first_name) throws SQLException;

    Abonent findForPhoneNumber(String phone_number) throws SQLException;
}
