package com.example.factura.controller;

import java.util.Date;
import java.util.UUID;

import com.example.factura.dao.ItemEntityDAO;
import com.example.factura.entity.ItemEntity;
import com.example.factura.model.ItemModel;

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
    private Button btnPagar;

    @FXML
    private Label lblIva;

    @FXML
    private Label lblSubtotal;

    @FXML
    private Label lblTotal;

    @FXML
    private Button limpiar;

    @FXML
    private TableView<ItemEntity> tblFactura;

    @FXML
    private TableColumn<ItemEntity, Long> tclCantidad;

    @FXML
    private TableColumn<ItemEntity, String> tclNombreProducto;

    @FXML
    private TableColumn<ItemEntity, Double> tclPrecio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecio;

    // Lista observable para almacenar los registros
    private ObservableList<ItemEntity> registroList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Vincula las columnas de la tabla con las propiedades del objeto ItemEntity
        tclNombreProducto.setCellValueFactory(new PropertyValueFactory<ItemEntity, String>("nombreProducto"));
        tclCantidad.setCellValueFactory(new PropertyValueFactory<ItemEntity, Long>("cantidad"));
        tclPrecio.setCellValueFactory(new PropertyValueFactory<ItemEntity, Double>("precio"));

        // Asigna la lista observable al TableView
        tblFactura.setItems(registroList);
    }

    @FXML
    void agregar(ActionEvent event) {
        Long cantidad = Long.valueOf(txtCantidad.getText());
        Double precio = Double.valueOf(txtPrecio.getText());

        Double calculo = cantidad * precio;

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setNombreProducto(txtNombreProducto.getText());
        itemEntity.setCantidad(cantidad);
        itemEntity.setPrecio(calculo);
        limpiarCajasTexto();
        registroList.add(itemEntity);

        // Calcular subtotal sumando los precios de todos los items
        double subtotal = registroList.stream()
                .mapToDouble(ItemEntity::getPrecio)
                .sum();
        // Calcular IVA (15% del subtotal)
        double iva = subtotal * 0.15;

        // Calcular total
        double total = subtotal + iva;
        // --------------
        lblSubtotal.setText(subtotal + "");
        lblIva.setText(iva + "");
        lblTotal.setText(total + "");

    }

    @FXML
    void limpiar(ActionEvent event) {
        limpiarCajasTexto();
        registroList.clear();
        limpiarLabel();
    }

    private void limpiarLabel() {
        lblSubtotal.setText("");
        lblIva.setText("");
        lblTotal.setText("");
    }

    void limpiarCajasTexto() {
        txtNombreProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
    }

    @FXML
    void pagar(ActionEvent event) {
        String codigoUnico = UUID.randomUUID().toString();

        for (ItemEntity item : registroList) {
            ItemModel objItemModel = new ItemModel();
            objItemModel.setNombreProducto(item.getNombreProducto());
            objItemModel.setCantidad(item.getCantidad().intValue());
            objItemModel.setPrecio(item.getPrecio());
            objItemModel.setUuid(codigoUnico);
            objItemModel.setFeCreacion(new Date());
            objItemModel.setUsrCreacion("wgaibor");
            objItemModel.setEstado("Activo");
            ItemEntityDAO itemEntityDAO = new ItemEntityDAO();
            itemEntityDAO.insert(objItemModel);
        }
    }

}
