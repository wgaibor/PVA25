package com.example.tienda.controller;

import com.example.tienda.dao.AdmiPaisDAO;
import com.example.tienda.model.AdmiPais;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SeleccionaPaisController implements Initializable {

    @FXML
    private ComboBox<AdmiPais> cmbPais;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AdmiPaisDAO dao = new AdmiPaisDAO();
        List<AdmiPais> paises = dao.findAll();
        cmbPais.setItems(FXCollections.observableArrayList(paises));
    }

    @FXML
    void selecciono(ActionEvent event) {

    }

}
