import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.AbonentService;

public class AbonentUpdateTest extends AbonentService {
    AbonentDAO abonentDAO = new AbonentDaoImpl();

    @Test(priority = 2)
    public void update() throws  Exception {
        Abonent abonent = new Abonent();
        abonent.setSecond_name("Blaumman");
        abonent.setFirst_name("Dirk");
        abonent.setPhone_number("+4915903906944");
        abonent.setId(7);
        abonentDAO.update(abonent);

        Abonent actualAbonent = findForSecondName(abonent.getSecond_name());

        String actualSecond_name = actualAbonent.getSecond_name();
        String actualFirst_name = actualAbonent.getFirst_name();
        String actualPhone_number = actualAbonent.getPhone_number();

        Assert.assertEquals(abonent.getSecond_name(), actualSecond_name);
        Assert.assertEquals(abonent.getFirst_name(), actualFirst_name);
        Assert.assertEquals(abonent.getPhone_number(), actualPhone_number);
    }
}
