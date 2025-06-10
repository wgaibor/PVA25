module com.example.persistence {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.persistence to javafx.fxml;

    exports com.example.persistence;

    opens com.example.persistence.model to jakarta.persistence, javafx.base, eclipselink;

    exports com.example.persistence.model;
}
