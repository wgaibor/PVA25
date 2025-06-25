package com.teclemas.factura.controller;

import com.teclemas.factura.entity.ProductoEntity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FacturaController {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnFacturar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<ProductoEntity> tblProducto;

    @FXML
    private TableColumn<ProductoEntity, Long> tclCantidad;

    @FXML
    private TableColumn<ProductoEntity, String> tclNombreProducto;

    @FXML
    private TableColumn<ProductoEntity, Double> tclPrecio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private Label txtFacturar;

    @FXML
    private Label txtIva;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioUnitario;

    @FXML
    private Label txtSubtotal;

    // Lista observable para almacenar los registros
    private ObservableList<ProductoEntity> registroList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        // Vincula las columnas de la tabla con las propiedades del objeto
        // ProductoEntity
        tclNombreProducto.setCellValueFactory(new PropertyValueFactory<ProductoEntity, String>("nombreProducto"));
        tclCantidad.setCellValueFactory(new PropertyValueFactory<ProductoEntity, Long>("cantidad"));
        tclPrecio.setCellValueFactory(new PropertyValueFactory<ProductoEntity, Double>("precio"));

        // Asigna la lista observable al TableView
        tblProducto.setItems(registroList);
    }

    @FXML
    void agregar(ActionEvent event) {
        String nombreProducto = txtNombreProducto.getText();
        Long cantidad = Long.parseLong(txtCantidad.getText());
        Double precio = Double.parseDouble(txtPrecioUnitario.getText());

        Double calculo = cantidad * precio;

        // Crea una nueva entidad ProductoEntity y la agrega a la lista observable
        ProductoEntity producto = new ProductoEntity();
        producto.setNombreProducto(nombreProducto);
        producto.setCantidad(cantidad);
        producto.setPrecio(calculo);

        registroList.add(producto);
    }

    @FXML
    void facturar(ActionEvent event) {

    }

    @FXML
    void limpiar(ActionEvent event) {

    }

}
