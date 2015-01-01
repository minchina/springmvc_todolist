package com.tw.todolist.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    protected static final String DRIVER = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://127.0.0.1:3306/scutcs";
    protected static final String USER = "root";
    protected static final String PASSWORD = "";
    Connection connection = getConnection();
    Statement statement;

    public Dao() throws SQLException {
        statement = connection.createStatement();
    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws SQLException {
        connection.close();
        statement.close();
    }
}
