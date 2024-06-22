package com.example.videogamesales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class VideoGameSalesApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();

        // Set up the primary stage
        primaryStage.setTitle("Video Game Sales Data"); // Set the title of the window
        primaryStage.setScene(new Scene(root, 800, 600)); // Set the size of the window

        // Set application icon
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/sales.png"))); // Set the application icon

        // Apply CSS Stylesheet
        Scene scene = primaryStage.getScene();
        scene.getStylesheets().add(getClass().getResource("/Styles.css").toExternalForm()); // Apply CSS stylesheet

        primaryStage.show(); // Display the primary stage
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
