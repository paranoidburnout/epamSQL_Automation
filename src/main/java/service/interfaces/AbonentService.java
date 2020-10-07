package service.interfaces;

import entity.Abonent;

import java.sql.SQLException;
import java.util.List;

public interface AbonentService {

    // Save abonent to database
    Abonent saveAbonent(Abonent abonent) throws SQLException;

    //Updates First_name, Second_name, Phone_number of abonent

    Abonent updateAbonent(Abonent abonent) throws SQLException;

    List<Abonent> getAbonents() throws SQLException;

    Abonent getAbonent(int id) throws SQLException;

}
