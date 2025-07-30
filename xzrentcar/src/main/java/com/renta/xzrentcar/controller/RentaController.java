package com.renta.xzrentcar.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import com.renta.xzrentcar.entity.ModeloVehiculoEntity;
import com.renta.xzrentcar.entity.RentaEntity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class RentaController {

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private CheckBox cbxTieneTC;

    @FXML
    private ComboBox<ModeloVehiculoEntity> cmbModelo;

    @FXML
    private DatePicker dpFeNacimiento;

    @FXML
    private TableView<RentaEntity> tblRenta;

    @FXML
    private TableColumn<RentaEntity, String> tcDNI;

    @FXML
    private TableColumn<RentaEntity, Date> tcFeNacimiento;

    @FXML
    private TableColumn<RentaEntity, String> tcMarca;

    @FXML
    private TableColumn<RentaEntity, String> tcModelo;

    @FXML
    private TableColumn<RentaEntity, String> tcNombre;

    @FXML
    private TableColumn<RentaEntity, String> tcTC;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtNombre;

    // Lista observable para almacenar los registros
    private ObservableList<RentaEntity> lstRenta = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        llenarComboModelo();

        // Configurar las columnas de la tabla
        tcDNI.setCellValueFactory(new PropertyValueFactory<RentaEntity, String>("dni"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<RentaEntity, String>("nombre"));
        tcModelo.setCellValueFactory(new PropertyValueFactory<RentaEntity, String>("modelo"));
        tcMarca.setCellValueFactory(new PropertyValueFactory<RentaEntity, String>("marca"));
        tcFeNacimiento.setCellValueFactory(new PropertyValueFactory<RentaEntity, Date>("fechaNacimiento"));
        tcTC.setCellValueFactory(new PropertyValueFactory<RentaEntity, String>("tieneTarjetaCredito"));

        // Asignar la lista observable a la tabla
        tblRenta.setItems(lstRenta);

        // Listener de campos de texto para limpiar el estilo al escribir y regresar al
        // estilo normal
        txtDNI.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                txtDNI.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-text-fill: black;");
            }
        });
        txtNombre.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                txtNombre.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-text-fill: black;");
            }
        });

        txtMarca.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                txtMarca.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-text-fill: black;");
            }
        });

    }

    private void llenarComboModelo() {
        List<ModeloVehiculoEntity> lstModelo = new ArrayList<ModeloVehiculoEntity>();

        ModeloVehiculoEntity objModelo = new ModeloVehiculoEntity();
        objModelo.setModelo("Moto");
        lstModelo.add(objModelo);

        objModelo = new ModeloVehiculoEntity();
        objModelo.setModelo("Sedan");
        lstModelo.add(objModelo);

        objModelo = new ModeloVehiculoEntity();
        objModelo.setModelo("Camioneta");
        lstModelo.add(objModelo);

        objModelo = new ModeloVehiculoEntity();
        objModelo.setModelo("SUV");
        lstModelo.add(objModelo);

        cmbModelo.getItems().addAll(lstModelo);
    }

    @FXML
    void guardar(ActionEvent event) {

        boolean esValidoFormulario = validadorFormulario();
        if (!esValidoFormulario) {
            return;
        }

        String dni = txtDNI.getText();
        String nombre = txtNombre.getText();
        String modelo = cmbModelo.getSelectionModel().getSelectedItem().getModelo();
        String marca = txtMarca.getText();
        Date feNacimiento = null;
        if (dpFeNacimiento.getValue() != null) {
            feNacimiento = java.util.Date
                    .from(dpFeNacimiento.getValue().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
        }

        String tieneTarjetaCredito = cbxTieneTC.isSelected() ? "Si" : "No";

        RentaEntity rentas = new RentaEntity();
        rentas.setDni(dni);
        rentas.setNombre(nombre);
        rentas.setModelo(modelo);
        rentas.setMarca(marca);
        rentas.setFechaNacimiento(feNacimiento);
        rentas.setTieneTarjetaCredito(tieneTarjetaCredito);

        lstRenta.add(rentas);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtDNI.clear();
        txtNombre.clear();
        cmbModelo.getSelectionModel().clearSelection();
        txtMarca.clear();
        dpFeNacimiento.setValue(null);
        cbxTieneTC.setSelected(false);
    }

    private boolean validadorFormulario() {

        if (txtDNI.getText().isEmpty()) {
            txtDNI.setStyle("-fx-border-color: red; -fx-background-color: lightpink;");
            alertarUsuario(Alert.AlertType.ERROR, "Error", "Por favor, ingrese un DNI válido.");
            return false;
        } else if (txtNombre.getText().isEmpty()) {
            txtNombre.setStyle("-fx-border-color: red; -fx-background-color: lightpink;");
            alertarUsuario(Alert.AlertType.ERROR, "Error", "Por favor, ingrese un nombre válido.");
            return false;
        } else if (cmbModelo.getSelectionModel().isEmpty()) {
            alertarUsuario(Alert.AlertType.ERROR, "Error", "Por favor, seleccione un modelo de vehículo.");
            return false;
        } else if (txtMarca.getText().isEmpty()) {
            txtMarca.setStyle("-fx-border-color: red; -fx-background-color: lightpink;");
            alertarUsuario(Alert.AlertType.ERROR, "Error", "Por favor, ingrese una marca válida.");
            return false;
        } else if (dpFeNacimiento.getValue() == null) {
            alertarUsuario(Alert.AlertType.ERROR, "Error", "Por favor, seleccione una fecha de nacimiento válida.");
            return false;
        }
        return true;
    }

    private void alertarUsuario(AlertType tipoAlerta, String titulo, String contenido) {
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @FXML
    void limpiar(ActionEvent event) {
        limpiarCampos();
        txtDNI.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-text-fill: black;");
        txtNombre.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-text-fill: black;");
        txtMarca.setStyle("-fx-border-color: black; -fx-background-color: white; -fx-text-fill: black;");
    }

}
