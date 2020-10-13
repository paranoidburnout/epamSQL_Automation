import java.sql.*;

public class SubServiceTest {
    public static void main(String[] args) throws SQLException {
        SubServiceTest sub_service = new SubServiceTest();
        sub_service.open();
        sub_service.select();
        sub_service.close();
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
                    "SELECT Abonent_id, Phone_service_id " +
                            " FROM Sub_service ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int Abonent_id = resultSet.getInt(1);
                int Phone_service_id = resultSet.getInt(2);


                System.out.println(Abonent_id + "\t|" + Phone_service_id);
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
