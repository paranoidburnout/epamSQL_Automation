package dao.sqlite.implementations;

import dao.sqlite.interfaces.PhoneServiceDAO;
import dao.connection.DB;
import entity.PhoneService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneServiceDaoImpl extends DB implements PhoneServiceDAO {
    Connection connection = getConnection();

    @Override
    public void create(PhoneService phone_service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Phone_service (NAME_OF_SERVICE, PRICE)" +
                "VALUES (?,?);";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, phone_service.getNAME_OF_SERVICE());
            preparedStatement.setDouble(3, phone_service.getPRICE());

            preparedStatement.executeUpdate();

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
    }

    @Override
    public void update(PhoneService phone_service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Phone_service SET NAME_OF_SERVICE=?, PRICE=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, phone_service.getNAME_OF_SERVICE());
            preparedStatement.setDouble(3, phone_service.getPRICE());
            preparedStatement.setInt(1, phone_service.getId());

            preparedStatement.executeUpdate();
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
    }

    @Override
    public void deleteById(int id) throws SQLException {

    }

    @Override
    public void delete(PhoneService phone_service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Phone_service WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, phone_service.getId());

            preparedStatement.executeUpdate();
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
    }


    @Override
    public PhoneService findById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT id, NAME_OF_SERVICE, PRICE FROM Phone_service WHERE id=?";
        PhoneService phone_service = new PhoneService();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            phone_service.setId(resultSet.getInt(1));
            phone_service.setNAME_OF_SERVICE(resultSet.getString("NAME_OF_SERVICE"));
            phone_service.setPRICE(resultSet.getDouble("PRICE"));

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
        return phone_service;
    }

    @Override
    public List<PhoneService> findAll() throws SQLException {
        List<PhoneService> phone_serviceList = new ArrayList<>();
        String sql = "SELECT id, NAME_OF_SERVICE, PRICE FROM Phone_service";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                PhoneService phone_service = new PhoneService();
                phone_service.setId(resultSet.getInt(1));
                phone_service.setNAME_OF_SERVICE(resultSet.getString("NAME_OF_SERVICE"));
                phone_service.setPRICE(resultSet.getDouble("PRICE"));

                phone_serviceList.add(phone_service);
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
        return phone_serviceList;
    }
}