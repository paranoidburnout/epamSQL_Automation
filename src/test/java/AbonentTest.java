
import java.sql.*;
import java.util.Scanner;

public class AbonentTest {
    public static void main(String[] args) throws SQLException {
        AbonentTest abonent = new AbonentTest();
        abonent.open();
//        abonent.insert();
        abonent.select();
        abonent.close();
    }

    Connection c;

    void open() {
        try {
            Class.forName("org.sqlite.JDBC"); //Загрузка драйвера БД
            c= DriverManager.getConnection("jdbc:dao.sqlite:Telephone_station.db"); //Установление связи с БД
            System.out.println("Connected");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//    void insert() {
//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter Abonent First_name: ");
//            String First_name = scanner.nextLine();
//            System.out.println("Enter Abonent Second_name: ");
//            String Second_name = scanner.nextLine();
//            System.out.println("Enter Abonent Phone_number: ");
//            String Phone_number = scanner.nextLine();
//
//            String query =
//                    "INSERT INTO Abonent (Second_name, First_name, Phone_number)" +
//                            "VALUES ('" + First_name + "' , '" + Second_name + "' , '" + Phone_number + "') ";
//            Statement statement = c.createStatement(); //простой sql запрос
//            statement.executeUpdate(query);
//
//            System.out.println("Rows added");
//            statement.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public void select() {
        try{
            Statement statement = c.createStatement();
            String query =
                    "SELECT id, First_name, Second_name, Phone_number " +
                            " FROM Abonent " +
                            "ORDER BY First_name";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String First_name = resultSet.getString("First_name");
                String Second_name = resultSet.getString("Second_name");
                String Phone_number = resultSet.getString("Phone_number");
                System.out.println(id + "\t|" + First_name + "\t|" + Second_name + "\t|" + Phone_number);
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void close() {
        try {
            c.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    }

//        try (PreparedStatement statement=dao.dao.dao.connection.prepareStatement("SELECT * FROM Abonent WHERE id = (?)")){
//    statement.setInt(1,1);
//    final ResultSet resultSet = statement.executeQuery();
//    if (resultSet.next()){
//        String byIndex = "Second_name: " + resultSet.getString(1);
//        final int Phone_number = resultSet.getInt("Phone");
//        System.out.println(byIndex);
//        System.out.println("Phone: "+ Phone_number);
//    }
//        }finally {
//            dao.dao.dao.connection.close();
//        }