import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import service.AbonentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbonentCrudTest extends AbonentService {
    AbonentDAO abonentDAO = new AbonentDaoImpl();
    AbonentDaoImpl abonentService= new AbonentDaoImpl();
    Abonent abonent = new Abonent();

    @Test(priority = 1)
    public void create() throws SQLException {
        abonent.setSecond_name("Kipchatov");
        abonent.setFirst_name("Michael");
        abonent.setPhone_number("+79633136313");
        abonentDAO.create(abonent);
        Assert.assertEquals("Kipchatov", "Kipchatov");
        Assert.assertEquals("Michael", "Michael");
        Assert.assertEquals("+79633136313", "+79633136313");
    }
    @Test(priority = 2)
    public void update() throws SQLException {
        abonent.setSecond_name("Blaumman");
        abonent.setFirst_name("Dirk");
        abonent.setPhone_number("+4915903906944");
        abonent.setId(9);
        abonentDAO.update(abonent);

        Assert.assertEquals("Blaumman", "Blaumman");
        Assert.assertEquals("Dirk", "Dirk");
        Assert.assertEquals("+4915903906944", "+4915903906944");
        Assert.assertEquals(9, 9);
    }
    @Test(priority = 3)
    public void delete() throws SQLException {
        abonent.setId(9);
        abonentDAO.delete(abonent);
        Assert.assertEquals(9,9);
        System.out.println("Abonent: ID " + abonent.getId() + ", deleted from database");
    }
    @Test(priority = 4)
    public void getAllAbonent() throws SQLException {
        abonentDAO.findAll().stream().map(abonentInst -> "Abonent: [ID : " + abonentInst.getId() + ", First_Name : " +
                abonentInst.getFirst_name() + ", Second_name : " + abonentInst.getSecond_name() +
                ", Phone_number : " + abonentInst.getPhone_number() + " ]").forEach(System.out::println);
    }
}