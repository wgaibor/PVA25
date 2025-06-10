package app.controller;

import app.model.Country;
import app.util.JpaUtil;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CountryController {

    @FXML
    private ComboBox<Country> countryComboBox;

    @FXML
    public void initialize() {
        loadCountries();
    }

    private void loadCountries() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
            List<Country> countries = query.getResultList();
            countryComboBox.getItems().addAll(countries);
        } finally {
            em.close();
        }
    }

    public void insertInitialCountries() {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            /*
             * em.persist(new Country("Ecuador"));
             * em.persist(new Country("Colombia"));
             * em.persist(new Country("Perú"));
             */
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}