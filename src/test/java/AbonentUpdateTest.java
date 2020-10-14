import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.AbonentService;

import java.sql.SQLException;

public class AbonentUpdateTest extends AbonentService {
    AbonentDAO abonentDAO = new AbonentDaoImpl();

    @Test(priority = 2)
    public void update() throws SQLException, Exception {
        Abonent abonent = new Abonent();
        abonent.setSecond_name("Blaumman");
        abonent.setFirst_name("Dirk");
        abonent.setPhone_number("+4915903906944");
        abonent.setId(22);
        abonentDAO.update(abonent);

        Assert.assertEquals("Blaumman", abonent.getSecond_name());
        Assert.assertEquals("Dirk", abonent.getFirst_name());
        Assert.assertEquals("+4915903906944", abonent.getPhone_number());
        Assert.assertEquals(22, abonent.getId());

    }
}
