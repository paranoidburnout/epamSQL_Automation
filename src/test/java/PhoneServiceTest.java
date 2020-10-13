import java.sql.*;

public class PhoneServiceTest {
    public static void main(String[] args) throws SQLException {
        PhoneServiceTest phone_service = new PhoneServiceTest();
        phone_service.open();
        phone_service.select();
        phone_service.close();
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
                    "SELECT id, NAME_OF_SERVICE, PRICE " +
                            " FROM Phone_service " +
                            "ORDER BY PRICE";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String NAME_OF_SERVICE = resultSet.getString("NAME_OF_SERVICE");
                double PRICE = resultSet.getDouble("PRICE");

                System.out.println(id + "\t|" + NAME_OF_SERVICE + "\t|" + PRICE);
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

