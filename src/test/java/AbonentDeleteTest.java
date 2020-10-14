import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AbonentDeleteTest {
    AbonentDAO abonentDAO = new AbonentDaoImpl();

    @Test(priority = 3)
    public void delete() throws SQLException, Exception {
        Abonent abonent = new Abonent();
        abonent.setId(7);
        abonentDAO.delete(abonent);

        Assert.assertEquals(7, abonent.getId());
        System.out.println("Abonent: ID " + abonent.getId() + ", deleted from database");
    }
}
