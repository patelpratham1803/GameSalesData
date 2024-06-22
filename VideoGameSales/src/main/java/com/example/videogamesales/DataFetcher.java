package com.example.videogamesales;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataFetcher {


    public List<SalesData> fetchData() {
        List<SalesData> salesDataList = new ArrayList<>();

        // SQL query to select game sales data from the database
        String query = "SELECT game_title, platform, year_of_release, genre, publisher, global_sales FROM sales_data";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Iterate through the result set and populate SalesData objects
            while (resultSet.next()) {
                String gameTitle = resultSet.getString("game_title");
                String platform = resultSet.getString("platform");
                int yearOfRelease = resultSet.getInt("year_of_release");
                String genre = resultSet.getString("genre");
                String publisher = resultSet.getString("publisher");
                BigDecimal globalSales = resultSet.getBigDecimal("global_sales");

                // Create a SalesData object with fetched data and add to the list
                SalesData data = new SalesData(gameTitle, platform, yearOfRelease, genre, publisher, globalSales);
                salesDataList.add(data);
            }
        } catch (SQLException e) {
            // Print details of any SQL Exception that occurs
            e.printStackTrace();
        }

        // Return the list of SalesData objects
        return salesDataList;
    }
}
