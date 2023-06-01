package com.example.mvcdepartament.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable{ // para o try-with-resources
    private static Connection connection; //variável precisa ser estática
    private static PreparedStatement statement; //variável precisa ser estática
    public static Connection createConnection() {
        try {
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:sqlite:department.db");
        }catch (SQLException e) { e.printStackTrace();}
        return connection;
    }
    public static PreparedStatement createPreparedStatement(String sql) {
        try {statement = createConnection().prepareStatement(sql);}
        catch (SQLException e) { e.printStackTrace();}
        return statement;
    }


    @Override
    public void close() throws Exception {
        if(connection != null) {
            connection.close();
            if (statement != null)
                statement.close();
        }
    }
}
