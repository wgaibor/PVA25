package com.teclemas.factura.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import com.teclemas.factura.dao.AdmiCaracteristicaDAO;
import com.teclemas.factura.dao.InfoFacturaDAO;
import com.teclemas.factura.dao.InfoFacturaDatoAdicionalDAO;
import com.teclemas.factura.dao.InfoItemDAO;
import com.teclemas.factura.entity.ProductoEntity;
import com.teclemas.factura.model.AdmiCaracteristicaModel;
import com.teclemas.factura.model.InfoFacturaDatoAdicionalModel;
import com.teclemas.factura.model.InfoFacturaModel;
import com.teclemas.factura.model.InfoItemModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.converter.LongStringConverter;

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
    private TableColumn<ProductoEntity, Void> tclAcciones;

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

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    private CheckBox chbDonante;

    // Lista observable para almacenar los registros
    private ObservableList<ProductoEntity> registroList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        tblProducto.setPlaceholder(new Label("No hay productos agregados"));
        tblProducto.setEditable(true);

        filtroDeExpresionesRegulares();

        // Vincula las columnas de la tabla con las propiedades del objeto
        // ProductoEntity
        tclNombreProducto.setCellValueFactory(new PropertyValueFactory<ProductoEntity, String>("nombreProducto"));
        tclCantidad.setCellValueFactory(new PropertyValueFactory<ProductoEntity, Long>("cantidad"));
        tclCantidad.setStyle(
                "-fx-alignment: CENTER; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill:rgb(6, 168, 117);");
        tclCantidad.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        tclCantidad.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProductoEntity, Long>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<ProductoEntity, Long> event) {
                ProductoEntity producto = event.getRowValue();
                producto.setCantidad(event.getNewValue());
            }
        });
        tclPrecio.setCellValueFactory(new PropertyValueFactory<ProductoEntity, Double>("precio"));

        // Configura la columna de acciones (puedes personalizarla según tus
        // necesidades)
        tclAcciones.setCellFactory(new Callback<TableColumn<ProductoEntity, Void>, TableCell<ProductoEntity, Void>>() {
            @Override
            public TableCell<ProductoEntity, Void> call(TableColumn<ProductoEntity, Void> col) {
                return new TableCell<ProductoEntity, Void>() {
                    private final Button btnUpdate = new Button("actualizar");
                    private final Button btnDelete = new Button("eliminar");
                    private final HBox pane = new HBox(5, btnUpdate, btnDelete);

                    {
                        btnUpdate.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                            @Override
                            public void handle(javafx.event.ActionEvent event) {
                                ProductoEntity producto = getTableView().getItems().get(getIndex());
                                // Lógica para actualizar el producto
                                // actualizarProducto(producto);
                            }
                        });

                        btnDelete.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                            @Override
                            public void handle(javafx.event.ActionEvent event) {
                                ProductoEntity producto = getTableView().getItems().get(getIndex());
                                getTableView().getItems().remove(producto);
                                // recalcular totales
                                calcularTotales();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : pane);
                    }
                };
            }
        });

        // Asigna la lista observable al TableView
        tblProducto.setItems(registroList);
    }

    private void filtroDeExpresionesRegulares() {
        // Para txtCantidad (solo enteros)
        txtCantidad.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtCantidad.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 3) {
                txtCantidad.setText(oldValue);
            }
        });

        // Para txtPrecioUnitario (números decimales)
        txtPrecioUnitario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                txtPrecioUnitario.setText(oldValue);
            }
        });

        // Para txtTelefonoCliente (solo enteros)
        txtTelefonoCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtTelefonoCliente.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > 10) {
                txtTelefonoCliente.setText(oldValue);
                txtTelefonoCliente.setStyle("");
            } else if (newValue.length() < 10) {
                txtTelefonoCliente.setStyle(
                        "-fx-border-color: red; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-background-color: cyan;");
            }
            if (newValue.length() == 0) {
                txtTelefonoCliente.setStyle("");
            }
        });

        txtCorreoCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && !Pattern.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$", newValue)) {
                txtCorreoCliente.setStyle("-fx-border-color: red;");
            } else {
                txtCorreoCliente.setStyle("");
            }
        });

    }

    @FXML
    void agregar(ActionEvent event) {
        boolean esValidoFormulario = validarCampos();
        if (!esValidoFormulario) {
            return;
        }
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
        calcularTotales();
        limpiarCajasTexto();
    }

    private boolean validarCampos() {
        if (txtNombreProducto.getText() == null || txtNombreProducto.getText().isEmpty()) {
            alertarUsuario(Alert.AlertType.ERROR, "ERROR", null,
                    "El campo Nombre del producto no puede ser vacio");
            return false;
        } else if (txtCantidad.getText() == null || txtCantidad.getText().isEmpty()) {
            alertarUsuario(Alert.AlertType.ERROR, "ERROR", null,
                    "El campo Cantidad no puede ser vacio");
            return false;
        } else if (txtPrecioUnitario.getText() == null || txtPrecioUnitario.getText().isEmpty()) {
            alertarUsuario(Alert.AlertType.ERROR, "ERROR", null,
                    "El campo Precio unitario no puede ser vacio");
            return false;
        }
        return true;
    }

    private void alertarUsuario(AlertType alerta, String titulo, String headerText, String contentText) {
        Alert alert = new Alert(alerta);
        alert.setTitle(titulo);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    @FXML
    void facturar(ActionEvent event) {

        String codigoUnico = UUID.randomUUID().toString();

        for (ProductoEntity productoEntity : registroList) {
            InfoItemModel infoItemModel = new InfoItemModel();
            infoItemModel.setUuid(codigoUnico);
            infoItemModel.setNombreProducto(productoEntity.getNombreProducto());
            infoItemModel.setCantidad(productoEntity.getCantidad().intValue());
            infoItemModel.setPrecio(
                    BigDecimal.valueOf(Double.parseDouble(productoEntity.getPrecio().toString().replace(",", "."))));
            infoItemModel.setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
            infoItemModel.setUsrCreacion("wgaibor");
            infoItemModel.setEstado("Activo");
            InfoItemDAO infoItemDAO = new InfoItemDAO();
            infoItemDAO.insert(infoItemModel);
        }

        InfoFacturaModel infoFacturaModel = new InfoFacturaModel();
        infoFacturaModel.setUuid(codigoUnico);
        infoFacturaModel.setSubtotal(BigDecimal.valueOf(Double.parseDouble(txtSubtotal.getText().replace(",", "."))));
        infoFacturaModel.setIva(BigDecimal.valueOf(Double.parseDouble(txtIva.getText().replace(",", "."))));
        infoFacturaModel.setTotal(BigDecimal.valueOf(Double.parseDouble(txtFacturar.getText().replace(",", "."))));
        infoFacturaModel.setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        infoFacturaModel.setUsrCreacion("wgaibor");
        infoFacturaModel.setEstado("Activo");
        InfoFacturaDAO infoFacturaDAO = new InfoFacturaDAO();
        infoFacturaDAO.insert(infoFacturaModel);

        // Recuperar el id de la factura recien creada
        infoFacturaModel = infoFacturaDAO.findByUuid(codigoUnico);

        // Recuperar la caracteristica nombre
        AdmiCaracteristicaModel admiCaracteristicaModel = new AdmiCaracteristicaModel();
        AdmiCaracteristicaDAO admiCaracteristicaDAO = new AdmiCaracteristicaDAO();
        admiCaracteristicaModel = admiCaracteristicaDAO.findBynombreCaracteristica("Nombre");
        // Vamos almacenar los datos del cliente de manera horizontal

        InfoFacturaDatoAdicionalModel infoFacturaDatoAdicionalModel = new InfoFacturaDatoAdicionalModel();
        infoFacturaDatoAdicionalModel.setFactura(infoFacturaModel);
        infoFacturaDatoAdicionalModel.setCaracteristica(admiCaracteristicaModel);
        infoFacturaDatoAdicionalModel.setValor(txtNombreCliente.getText());
        infoFacturaDatoAdicionalModel
                .setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        infoFacturaDatoAdicionalModel.setUsrCreacion("wgaibor");
        infoFacturaDatoAdicionalModel.setEstado("Activo");

        InfoFacturaDatoAdicionalDAO infoFacturaDatoAdicionalDAO = new InfoFacturaDatoAdicionalDAO();
        infoFacturaDatoAdicionalDAO.insert(infoFacturaDatoAdicionalModel);

        // Guardar el correo del cliente
        admiCaracteristicaModel = admiCaracteristicaDAO.findBynombreCaracteristica("Correo");

        infoFacturaDatoAdicionalModel = new InfoFacturaDatoAdicionalModel();
        infoFacturaDatoAdicionalModel.setFactura(infoFacturaModel);
        infoFacturaDatoAdicionalModel.setCaracteristica(admiCaracteristicaModel);
        infoFacturaDatoAdicionalModel.setValor(txtCorreoCliente.getText());
        infoFacturaDatoAdicionalModel
                .setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        infoFacturaDatoAdicionalModel.setUsrCreacion("wgaibor");
        infoFacturaDatoAdicionalModel.setEstado("Activo");
        infoFacturaDatoAdicionalDAO.insert(infoFacturaDatoAdicionalModel);

        // Guardar el telefono del cliente
        admiCaracteristicaModel = admiCaracteristicaDAO.findBynombreCaracteristica("Telefono");

        infoFacturaDatoAdicionalModel = new InfoFacturaDatoAdicionalModel();
        infoFacturaDatoAdicionalModel.setFactura(infoFacturaModel);
        infoFacturaDatoAdicionalModel.setCaracteristica(admiCaracteristicaModel);
        infoFacturaDatoAdicionalModel.setValor(txtTelefonoCliente.getText());
        infoFacturaDatoAdicionalModel
                .setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        infoFacturaDatoAdicionalModel.setUsrCreacion("wgaibor");
        infoFacturaDatoAdicionalModel.setEstado("Activo");
        infoFacturaDatoAdicionalDAO.insert(infoFacturaDatoAdicionalModel);

        // Guardar si es donante
        admiCaracteristicaModel = admiCaracteristicaDAO.findBynombreCaracteristica("Donante");
        if (admiCaracteristicaModel == null) {
            // Alertar al usuario que no existe la caracteristica con un alert
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("La característica 'Donante' no existe en la base de datos.");
            alert.showAndWait();

            admiCaracteristicaModel = new AdmiCaracteristicaModel();
            admiCaracteristicaModel.setNombreCaracteristica("Donante");
            admiCaracteristicaModel
                    .setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
            admiCaracteristicaModel.setUsrCreacion("wgaibor");
            admiCaracteristicaModel.setEstado("Activo");
            AdmiCaracteristicaDAO admiCaracteristicaDAONew = new AdmiCaracteristicaDAO();
            admiCaracteristicaDAONew.insert(admiCaracteristicaModel);
        }

        infoFacturaDatoAdicionalModel = new InfoFacturaDatoAdicionalModel();
        infoFacturaDatoAdicionalModel.setFactura(infoFacturaModel);
        infoFacturaDatoAdicionalModel.setCaracteristica(admiCaracteristicaModel);
        infoFacturaDatoAdicionalModel.setValor(chbDonante.isSelected() ? "Sí" : "No");
        infoFacturaDatoAdicionalModel
                .setFeCreacion(new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        infoFacturaDatoAdicionalModel.setUsrCreacion("wgaibor");
        infoFacturaDatoAdicionalModel.setEstado("Activo");
        infoFacturaDatoAdicionalDAO.insert(infoFacturaDatoAdicionalModel);

        limpiarCajasTexto();
        limpiarPantalla();

    }

    @FXML
    void limpiar(ActionEvent event) {
        limpiarCajasTexto();
        limpiarPantalla();
    }

    // Método para calcular los totales de la factura
    private void calcularTotales() {
        double subtotal = 0.0;
        for (ProductoEntity producto : registroList) {
            subtotal += producto.getPrecio();
        }
        double iva = subtotal * 0.15; // Suponiendo un IVA del 15%
        double total = subtotal + iva;

        txtSubtotal.setText(String.format("%.2f", subtotal));
        txtIva.setText(String.format("%.2f", iva));
        txtFacturar.setText(String.format("%.2f", total));
    }

    // Método para limpiar las cajas de texto de entrada
    private void limpiarCajasTexto() {
        txtNombreProducto.clear();
        txtCantidad.clear();
        txtPrecioUnitario.clear();
    }

    // Método para limpiar la pantalla (por ejemplo, limpiar la tabla y los totales)
    private void limpiarPantalla() {
        registroList.clear();
        txtSubtotal.setText("");
        txtIva.setText("");
        txtFacturar.setText("");
        txtNombreCliente.clear();
        txtCorreoCliente.clear();
        txtTelefonoCliente.clear();
        chbDonante.setSelected(false);
    }

}
