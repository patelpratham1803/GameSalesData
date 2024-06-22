package com.example.videogamesales;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.util.List;

public class MainController {

    @FXML
    private TableView<SalesData> tableView;

    @FXML
    private TableColumn<SalesData, String> titleColumn;

    @FXML
    private TableColumn<SalesData, String> platformColumn;

    @FXML
    private TableColumn<SalesData, Integer> yearColumn;

    @FXML
    private TableColumn<SalesData, String> genreColumn;

    @FXML
    private TableColumn<SalesData, String> publisherColumn;

    @FXML
    private TableColumn<SalesData, BigDecimal> salesColumn;

    @FXML
    private PieChart pieChart;

    //Fetches data from the database and populates the table view and pie chart.
    public void initialize() {
        // Fetch data from the database
        DataFetcher dataFetcher = new DataFetcher();
        List<SalesData> dataList = dataFetcher.fetchData();

        // Convert list to observable list for table view
        ObservableList<SalesData> data = FXCollections.observableArrayList(dataList);

        // Set cell value factories for table columns
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfRelease"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("globalSales"));

        // Populate table view with data
        tableView.setItems(data);

        // Populate pie chart initially
        populatePieChart();
    }

    //Switches between table view and pie chart visibility based on button click.If table view is visible, switches to pie chart; otherwise, switches back to table view.

    @FXML
    private void handleShowChartButtonAction() {
        if (tableView.isVisible()) {
            // Switch to pie chart view
            tableView.setVisible(false);
            pieChart.setVisible(true);
            populatePieChart();
        } else {
            // Switch back to table view
            pieChart.setVisible(false);
            tableView.setVisible(true);
        }
    }

    //Uses game titles as pie chart slice labels and global sales as slice values.

    private void populatePieChart() {
        pieChart.getData().clear(); // Clear existing pie chart data

        // Get data from table view
        List<SalesData> dataList = tableView.getItems();

        // Populate pie chart with data
        for (SalesData salesData : dataList) {
            PieChart.Data slice = new PieChart.Data(salesData.getGameTitle(), salesData.getGlobalSales().doubleValue());
            pieChart.getData().add(slice);
        }
    }
}
