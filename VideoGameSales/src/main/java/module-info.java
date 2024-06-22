module com.example.videogamesales {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.videogamesales to javafx.fxml;
    exports com.example.videogamesales;
}