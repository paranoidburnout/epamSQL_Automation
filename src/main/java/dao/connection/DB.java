package dao.connection;

import java.sql.*;

public class DB {
    private static final String DB_DRIVER = "org.dao.sqlite.JDBC";
    private static final String DB_URL = "jdbc:dao.sqlite:Telephone_station.db";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection=DriverManager.getConnection(DB_URL);
            System.out.println("Connected");
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return connection;

    }
}

