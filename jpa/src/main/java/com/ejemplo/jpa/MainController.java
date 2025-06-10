package com.ejemplo.jpa;

import com.ejemplo.jpa.model.Pais;
import com.ejemplo.jpa.service.PaisService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.List;

public class MainController {

    @FXML
    private ComboBox<Pais> comboPaises;

    private PaisService paisService = new PaisService();

    @FXML
    public void initialize() {
        paisService.insertarPaisesIniciales();

        List<Pais> lista = paisService.listarPaises();
        comboPaises.getItems().addAll(lista);
    }
}
