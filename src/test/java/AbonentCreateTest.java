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
    public void create() throws Exception {
        Abonent abonent = new Abonent();
        abonent.setSecond_name("Kipchatov");
        abonent.setFirst_name("Michael");
        abonent.setPhone_number("+79633136313");
        abonentDAO.create(abonent);

        Abonent actualAbonent = findForSecondName(abonent.getSecond_name());

        String actualSecond_name = actualAbonent.getSecond_name();
        String actualFirst_name =  actualAbonent.getFirst_name();
        String actualPhone_number = actualAbonent.getPhone_number();

        Assert.assertEquals(abonent.getSecond_name(), actualSecond_name);
        Assert.assertEquals(abonent.getFirst_name(), actualFirst_name);
        Assert.assertEquals(abonent.getPhone_number(), actualPhone_number);

    }
}