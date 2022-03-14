package com.example.testapplicationjava.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Driver and the database
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/EmployeeDB";

    // Credentials
    private static final String USER = System.getenv("POSTGRES_USER");
    private static final String PASSWORD = System.getenv("POSTGRES_PASSWORD");

    private static Connection connection = null;

    public static Connection connect() {
        // Register the driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish a connection
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
