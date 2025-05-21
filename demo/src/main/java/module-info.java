module com.lemas.facturador {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lemas.facturador to javafx.fxml;
    exports com.lemas.facturador;
}
