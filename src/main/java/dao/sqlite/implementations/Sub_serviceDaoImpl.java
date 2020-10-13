package dao.sqlite.implementations;

import dao.connection.DB;
import dao.sqlite.interfaces.Sub_serviceDAO;
import entity.Sub_service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sub_serviceDaoImpl extends DB implements Sub_serviceDAO {
    Connection connection = getConnection();

    @Override
    public void create(Sub_service sub_service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Sub_service (Abonent_id, Phone_service_id)" +
                "VALUES ( ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, sub_service.getAbonent_id());
            preparedStatement.setInt(2, sub_service.getPhone_service_id());


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
    public List<Sub_service> findAll() throws SQLException {
        List<Sub_service> sub_services = new ArrayList<>();
        String sql = "SELECT Abonent_id, Phone_service_id FROM Sub_service";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Sub_service sub_service = new Sub_service();
                sub_service.setAbonent_id(resultSet.getInt(1));
                sub_service.setPhone_service_id(resultSet.getInt(2));

                sub_services.add(sub_service);
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
        return sub_services;
    }

    @Override
    public Sub_service findByAbonent_idAndPhone_service_id(int Abonent_id, int Phone_service_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT Abonent_id, Phone_service_id FROM Sub_service WHERE Abonent_id=? AND Phone_service_id=?";
        Sub_service sub_service = new Sub_service();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Abonent_id);
            preparedStatement.setInt(2, Phone_service_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            sub_service.setAbonent_id(resultSet.getInt(1));
            sub_service.setPhone_service_id(resultSet.getInt(2));

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
        return sub_service;
    }

    @Override
    public Sub_service findByAbonentId(int Abonent_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT Abonent_id, Phone_service_id FROM Sub_service WHERE Abonent_id=?";
        Sub_service sub_service = new Sub_service();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Abonent_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            sub_service.setAbonent_id(resultSet.getInt(1));
            sub_service.setPhone_service_id(resultSet.getInt(2));
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
        return sub_service;
    }

    @Override
    public Sub_service findByPhoneServiceId(int Phone_service_id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT Abonent_id, Phone_service_id FROM Sub_service WHERE Phone_service_id=?";
        Sub_service sub_service = new Sub_service();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2, Phone_service_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            sub_service.setPhone_service_id(resultSet.getInt(2));
            sub_service.setAbonent_id(resultSet.getInt(1));

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
        return null;
    }

    @Override
    public void update(Sub_service sub_service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Sub_service SET Abonent_id=?, Phone_service_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, sub_service.getAbonent_id());
            preparedStatement.setInt(2, sub_service.getPhone_service_id());

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
    public void delete(Sub_service sub_service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Sub_service WHERE Abonent_id=? AND Phone_service_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, sub_service.getAbonent_id());
            preparedStatement.setInt(2, sub_service.getPhone_service_id());

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
    public Sub_service findById(int id) throws SQLException {
        return null;
    }
}
