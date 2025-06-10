module com.ejemplo.jpa {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ejemplo.jpa to javafx.fxml;
    exports com.ejemplo.jpa;
}
