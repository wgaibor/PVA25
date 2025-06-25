module com.teclemas.factura {
    requires javafx.controls;
    requires javafx.fxml;

    requires jakarta.persistence;
    requires java.sql;

    opens com.teclemas.factura to javafx.fxml;

    exports com.teclemas.factura;

    opens com.teclemas.factura.model to javafx.base, jakarta.persistence, eclipselink;

    exports com.teclemas.factura.model;

    opens com.teclemas.factura.controller to javafx.fxml;

    exports com.teclemas.factura.controller;

    opens com.teclemas.factura.entity to javafx.base;

    exports com.teclemas.factura.entity;
}
