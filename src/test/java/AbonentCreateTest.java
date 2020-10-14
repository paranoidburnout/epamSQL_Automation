import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;
import org.testng.annotations.Test;
import org.testng.Assert;
import service.AbonentService;

import java.sql.SQLException;


public class AbonentCreateTest extends AbonentService {
    AbonentDAO abonentDAO = new AbonentDaoImpl();

    @Test(priority = 1)
    public void create() throws Exception, SQLException {
        Abonent abonent = new Abonent();
        abonent.setSecond_name("Kipchatov");
        abonent.setFirst_name("Michael");
        abonent.setPhone_number("+79633136313");
        abonentDAO.create(abonent);

        Assert.assertEquals("Kipchatov", abonent.getSecond_name());
        Assert.assertEquals("Michael", abonent.getFirst_name());
        Assert.assertEquals("+79633136313", abonent.getPhone_number());

    }
}