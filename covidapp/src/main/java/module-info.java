module com.example.covidapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires json.simple;
    requires java.desktop;
    requires java.compiler;


    opens com.example.covidapp to javafx.fxml;
    exports com.example.covidapp;
}