
import java.sql.*;


public class AbonentTest {
    public static void main(String[] args)  {
        AbonentTest abonent = new AbonentTest();
        abonent.open();
        abonent.select();
        abonent.close();
    }

    Connection c;

    void open() {
        try {
            Class.forName("org.sqlite.JDBC"); //Загрузка драйвера БД
            c = DriverManager.getConnection("jdbc:sqlite:Telephone_station.db"); //Установление связи с БД
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void select() {
        try {
            Statement statement = c.createStatement();
            String query =
                    "SELECT id, First_name, Second_name, Phone_number " +
                            " FROM Abonent " +
                            "ORDER BY First_name";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String First_name = resultSet.getString("First_name");
                String Second_name = resultSet.getString("Second_name");
                String Phone_number = resultSet.getString("Phone_number");
                System.out.println(id + "\t|" + First_name + "\t|" + Second_name + "\t|" + Phone_number);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void close() {
        try {
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}