package com.example.factura.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.example.factura.dao.AdmiPaisDAO;
import com.example.factura.model.AdmiPais;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class SeleccionaPaisController implements Initializable {

    @FXML
    private ComboBox<AdmiPais> cmbPais;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        AdmiPaisDAO dao = new AdmiPaisDAO();
        List<AdmiPais> paises = dao.findAll();
        cmbPais.setItems(FXCollections.observableArrayList(paises));
    }

}
