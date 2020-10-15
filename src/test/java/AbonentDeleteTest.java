import dao.sqlite.implementations.AbonentDaoImpl;
import dao.sqlite.interfaces.AbonentDAO;
import entity.Abonent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AbonentDeleteTest {
    AbonentDAO abonentDAO = new AbonentDaoImpl();

    @Test(priority = 3, expectedExceptions = NullPointerException.class)
    public void delete() throws Exception {
        Abonent abonent = new Abonent();
        abonent.setId(7);
        abonentDAO.delete(abonent);
        Abonent actualAbonent = abonentDAO.findById(abonent.getId());

        Assert.assertEquals(abonent.getId(), actualAbonent.getId());
        System.out.println("Abonent: ID " + abonent.getId() + ", deleted from database");
    }
}
