package com.example.persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import com.example.persistence.model.AdmiPais;
import com.example.persistence.util.JPAUtil;

import jakarta.persistence.EntityManager;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<AdmiPais> paises = em.createQuery("SELECT a FROM AdmiPais a", AdmiPais.class).getResultList();
            paises.forEach(p -> System.out.println(p.getPais()));
        } finally {
            em.close();
        }
        launch();
    }

}