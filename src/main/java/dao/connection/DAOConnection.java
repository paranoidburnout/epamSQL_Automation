package dao.connection;

import java.sql.Connection;

public abstract class DAOConnection {
    protected Connection connection;
    public DAOConnection(Connection connection){
        this.connection = connection;
    }
}
