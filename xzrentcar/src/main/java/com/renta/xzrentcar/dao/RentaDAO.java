package com.renta.xzrentcar.dao;

import java.util.ArrayList;
import java.util.List;

import com.renta.xzrentcar.model.InfoRentaModel;
import com.renta.xzrentcar.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RentaDAO {

    public void insertar(InfoRentaModel infoRentaModel) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(infoRentaModel);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public List<InfoRentaModel> obtenerItems() {
        List<InfoRentaModel> lstInfoRenta = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        lstInfoRenta = em.createQuery("SELECT f FROM InfoRentaModel f", InfoRentaModel.class).getResultList();
        em.close();
        return lstInfoRenta;
    }
}
