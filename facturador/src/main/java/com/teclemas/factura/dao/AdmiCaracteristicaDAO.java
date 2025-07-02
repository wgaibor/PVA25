package com.teclemas.factura.dao;

import com.teclemas.factura.model.AdmiCaracteristicaModel;
import com.teclemas.factura.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class AdmiCaracteristicaDAO {

    public AdmiCaracteristicaModel findBynombreCaracteristica(String nombre) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em
                    .createQuery("SELECT a FROM AdmiCaracteristicaModel a WHERE a.nombreCaracteristica = :nombre",
                            AdmiCaracteristicaModel.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

}
