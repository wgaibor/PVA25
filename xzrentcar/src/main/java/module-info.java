module com.renta.xzrentcar {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    requires jakarta.persistence;
    requires java.sql;

    opens com.renta.xzrentcar to javafx.fxml;

    exports com.renta.xzrentcar;

    opens com.renta.xzrentcar.model to jakarta.persistence, eclipselink;

    exports com.renta.xzrentcar.model;

    opens com.renta.xzrentcar.controller to javafx.fxml;

    exports com.renta.xzrentcar.controller;

    exports com.renta.xzrentcar.entity;
}
