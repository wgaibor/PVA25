package com.teclemas.factura.dao;

import java.util.List;

import com.teclemas.factura.model.InfoFacturaModel;
import com.teclemas.factura.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InfoFacturaDAO {

    public List<InfoFacturaModel> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<InfoFacturaModel> facturas = em.createQuery("SELECT f FROM InfoFacturaModel f", InfoFacturaModel.class)
                .getResultList();
        em.close();
        return facturas;
    }

    public void insert(InfoFacturaModel factura) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(factura);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public InfoFacturaModel findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(InfoFacturaModel.class, id);
        } finally {
            em.close();
        }
    }

    public void update(InfoFacturaModel factura) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(factura);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(InfoFacturaModel factura) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(factura) ? factura : em.merge(factura));
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
