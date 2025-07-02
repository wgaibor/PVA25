package com.teclemas.factura.dao;

import java.util.List;

import com.teclemas.factura.model.InfoFacturaDatoAdicionalModel;
import com.teclemas.factura.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InfoFacturaDatoAdicionalDAO {

    public List<InfoFacturaDatoAdicionalModel> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<InfoFacturaDatoAdicionalModel> facturas = em
                .createQuery("SELECT f FROM InfoFacturaDatoAdicionalModel f", InfoFacturaDatoAdicionalModel.class)
                .getResultList();
        em.close();
        return facturas;
    }

    public void insert(InfoFacturaDatoAdicionalModel facturaDatoAdicional) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(facturaDatoAdicional);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Rethrow the exception to handle it at a higher level
        } finally {
            em.close();
        }
    }

    public InfoFacturaDatoAdicionalModel findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(InfoFacturaDatoAdicionalModel.class, id);
        } finally {
            em.close();
        }
    }

    public void update(InfoFacturaDatoAdicionalModel facturaDatoAdicional) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(facturaDatoAdicional);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Rethrow the exception to handle it at a higher level
        } finally {
            em.close();
        }
    }

    public void delete(InfoFacturaDatoAdicionalModel facturaDatoAdicional) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.contains(facturaDatoAdicional) ? facturaDatoAdicional : em.merge(facturaDatoAdicional));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Rethrow the exception to handle it at a higher level
        } finally {
            em.close();
        }
    }

}
