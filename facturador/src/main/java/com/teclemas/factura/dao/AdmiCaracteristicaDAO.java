package com.teclemas.factura.dao;

import com.teclemas.factura.model.AdmiCaracteristicaModel;
import com.teclemas.factura.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AdmiCaracteristicaDAO {

    public AdmiCaracteristicaModel findBynombreCaracteristica(String nombre) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em
                    .createQuery("SELECT a FROM AdmiCaracteristicaModel a WHERE a.nombreCaracteristica = :nombre",
                            AdmiCaracteristicaModel.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public void insert(AdmiCaracteristicaModel admiCaracteristicaModel) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(admiCaracteristicaModel);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}
