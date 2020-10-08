package dao.SQLite.implementations;

import dao.SQLite.interfaces.AbonentDAO;
import dao.connection.DB;
import entity.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonentDaoImpl extends DB implements AbonentDAO {

    Connection connection = getConnection();

    @Override
    public void create(Abonent abonent) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Abonent (Second_name, First_name, Phone_number)" +
                "VALUES ( ?, ?, ?)";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, abonent.getSecond_name());
            preparedStatement.setString(3, abonent.getFirst_name());
            preparedStatement.setString(4, abonent.getPhone_number());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<Abonent> findAll() throws SQLException {
        List<Abonent> abonentList = new ArrayList<>();

        String sql = "SELECT id, First_name, Second_name, Phone_number FROM Abonent";
        Statement statement =null;
        try{
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Abonent abonent = new Abonent();
                abonent.setId(resultSet.getInt("id"));
                abonent.setFirst_name(resultSet.getString("First_name"));
                abonent.setSecond_name(resultSet.getString("Second_name"));
                abonent.setPhone_number(resultSet.getString("Phone_number"));

                abonentList.add(abonent);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (statement !=null){
                statement.close();
            }
            if (connection !=null){
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
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            abonent.setId(resultSet.getInt(1));
            abonent.setFirst_name(resultSet.getString("First_name"));
            abonent.setSecond_name(resultSet.getString("Second_name"));
            abonent.setPhone_number(resultSet.getString("Phone_number"));
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection !=null){
                connection.close();
            }
        }
        return abonent;
    }

    @Override
    public void update(Abonent abonent) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE Abonent SET First_name=?, Second_name=?, Phone_number=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, abonent.getFirst_name());
            preparedStatement.setString(3, abonent.getSecond_name());
            preparedStatement.setString(4, abonent.getPhone_number());
            preparedStatement.setInt(1, abonent.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection !=null){
                connection.close();
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void delete(Abonent abonent) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM Abonent WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, abonent.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (preparedStatement !=null){
                preparedStatement.close();
            }
            if (connection !=null){
                connection.close();
            }
        }
    }
}

//public class AbonentDaoImpl implements AbonentDAO {
//    List<Abonent> abonents;
//    public AbonentDaoImpl(Connection dao.connection){
//        abonents = new ArrayList<Abonent>();
//        Abonent abonent1 = new Abonent(0,"Patrakov", "Ivan", "+7 905 587 26 04");
//        abonents.add(abonent1);
//    }
//    @Override
//    public void deleteAbonent(Abonent abonent) {
//        abonents.remove(abonent.getId());
//        System.out.println("Abonent: ID " + abonent.getId() + ", deleted from database");
//    }
//    @Override
//    public List<Abonent> getAllAbonents() {
//        return abonents;
//    }
//
//    @Override
//    public Abonent getAbonent(int id) {
//        return abonents.get(id);
//    }
//
//    @Override
//    public void updateAbonent(Abonent abonent) {
//        abonents.get(abonent.getId()).setPhone_number(abonent.getPhone_number());
//        System.out.println("Abonent: ID " + abonent.getId() + ", updated in the database");
//
//    }


//}
