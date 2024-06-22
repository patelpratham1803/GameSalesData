package com.example.videogamesales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // JDBC URL to connect to MySQL database running locally on port 3306
    private static final String URL = "jdbc:mysql://localhost:3306/video_game_sales";

    // MySQL database username
    private static final String USER = "root";

    // MySQL database password
    private static final String PASSWORD = "Pratham@1218";

    /**
     * Establishes a connection to the MySQL database.
     *
     * @return Connection object if successful, null if connection fails
     */
    public static Connection getConnection() {
        try {
            // Attempt to establish a connection using DriverManager
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Print details of any SQL Exception that occurs
            e.printStackTrace();
            return null; // Return null indicating connection failure
        }
    }
}
