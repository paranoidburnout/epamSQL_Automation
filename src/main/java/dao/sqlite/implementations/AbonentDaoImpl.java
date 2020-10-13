package dao.sqlite.implementations;

import dao.sqlite.interfaces.AbonentDAO;
import dao.connection.DB;
import entity.Abonent;

import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AbonentDaoImpl extends DB implements AbonentDAO {
    Connection connection = getConnection();

    @Override
    public void create(Abonent abonent) throws SQLException {
        try {
            String first_name = "Kipchatov";
            String second_name = "Michael";
            String phone_number = "+79633136313";

            String query =
                    "INSERT INTO Abonent (Second_name, First_name, Phone_number)" +
                            "VALUES ('" + first_name + "' , '" + second_name + "' , '" + phone_number + "') ";
            Statement statement = connection.createStatement(); //простой sql запрос
            statement.executeUpdate(query);

            System.out.println("Rows added");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
//        } finally {
//            if (preparedStatement != null) {
//                preparedStatement.close();
//            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Abonent> findAll() throws SQLException {
        List<Abonent> abonentList = new ArrayList<>();
        String sql = "SELECT id, First_name, Second_name, Phone_number FROM Abonent";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("id"));
                abonent.setFirst_name(resultSet.getString("First_name"));
                abonent.setSecond_name(resultSet.getString("Second_name"));
                abonent.setPhone_number(resultSet.getString("Phone_number"));

                abonentList.add(abonent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return abonentList;
    }

    @Override
    public Abonent findById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT id, First_name, Second_name, Phone_number FROM Abonent WHERE id=?";
        Abonent abonent = new Abonent();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            abonent.setId(resultSet.getInt(1));
            abonent.setFirst_name(resultSet.getString("First_name"));
            abonent.setSecond_name(resultSet.getString("Second_name"));
            abonent.setPhone_number(resultSet.getString("Phone_number"));
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return abonent;
    }

    @Override
    public void update(Abonent abonent) throws SQLException {
        try {
            String first_name = "Blaumman";
            String second_name = "Dirk";
            String phone_number = "+4915903906944";
            int id = 6;

            String query =
                    "UPDATE Abonent SET  First_name=('" + first_name + "'),Second_name=('" + second_name + "'), Phone_number=('" + phone_number + "') WHERE id=('" + id + "')";

            Statement statement = connection.createStatement(); //простой sql запрос
            statement.executeUpdate(query);

            System.out.println("Rows updated");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
    }

    @Override
    public void delete(Abonent abonent) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            int id = 9;
            String query = "DELETE FROM Abonent WHERE id=('"+id+"')";

            Statement statement = connection.createStatement(); //простой sql запрос
            statement.executeUpdate(query);

            System.out.println("Rows deleted");
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                connection.close();
            }
        }
    }
}
