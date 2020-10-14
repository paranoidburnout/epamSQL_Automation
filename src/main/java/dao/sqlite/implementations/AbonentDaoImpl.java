package dao.sqlite.implementations;

import dao.sqlite.interfaces.AbonentDAO;
import dao.connection.DB;
import entity.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonentDaoImpl extends DB implements AbonentDAO {
    Connection connection = getConnection();

    @Override
    public void create(Abonent abonent) throws Exception {
        Statement statement = null;
        int result=0;

        try {
            statement = connection.createStatement();
            String sql =
                    "INSERT INTO Abonent (First_name, Second_name, Phone_number)" +
                            "VALUES ('" + abonent.getFirst_name() + "' , '" + abonent.getSecond_name() + "' , "
            + "'" + abonent.getPhone_number() + "') ";
            result = statement.executeUpdate(sql);

            if (result==1){
                Abonent abonent1 = new Abonent();
                abonent1.setFirst_name(abonent.getFirst_name());
                abonent1.setSecond_name(abonent.getSecond_name());
                abonent1.setPhone_number(abonent.getPhone_number());
                System.out.println("Rows added");
            }else throw new Exception("Unable to insert Abonent");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
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
    public void update(Abonent abonent) throws Exception {
        Statement statement = null;
        int result = 0;
        try {
            statement=connection.createStatement();

            String sql =
                    "UPDATE Abonent SET First_name=('" + abonent.getFirst_name() + "'), "
            +"Second_name=('" + abonent.getSecond_name() + "'), Phone_number=('" + abonent.getPhone_number() + "')"
            +"WHERE id=('" + abonent.getId() + "')";

            result = statement.executeUpdate(sql);
            System.out.println("Rows updated");
            if (result!=1){
                throw new Exception("Unable to update Abonent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
    }

    @Override
    public void delete(Abonent abonent) throws Exception {
        if (abonent==null){
            return;
        }
        Statement statement = null;
        int result = 0;
        try {
            statement = connection.createStatement();
            String sql = "DELETE FROM Abonent WHERE id=('"+abonent.getId()+"')";
            result = statement.executeUpdate(sql);
            System.out.println("Rows deleted");
            if (result !=1){
                throw new Exception("Unable to delete Abonent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }finally {
                if (statement != null) {
                    statement.close();
                }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
