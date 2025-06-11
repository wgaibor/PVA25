module com.example.factura {
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.persistence;
    requires java.sql;

    opens com.example.factura to javafx.fxml;

    exports com.example.factura;

    opens com.example.factura.model to javafx.base, jakarta.persistence, eclipselink;

    exports com.example.factura.model;

    opens com.example.factura.controller to javafx.fxml;

    exports com.example.factura.controller;

    opens com.example.factura.entity to javafx.base;
}
