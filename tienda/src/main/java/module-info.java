module com.example.tienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.tienda to javafx.fxml;

    exports com.example.tienda;

    opens com.example.tienda.model to javafx.base, jakarta.persistence, eclipselink;

    exports com.example.tienda.model;

    opens com.example.tienda.controller to javafx.fxml;

    exports com.example.tienda.controller;
}
