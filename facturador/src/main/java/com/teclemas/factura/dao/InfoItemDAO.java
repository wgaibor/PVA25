package com.teclemas.factura.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import com.teclemas.factura.util.JPAUtil;

import java.util.List;

import com.teclemas.factura.model.InfoItemModel;

public class InfoItemDAO {

    public List<InfoItemModel> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<InfoItemModel> items = em.createQuery("SELECT i FROM InfoItemModel i", InfoItemModel.class)
                .getResultList();
        em.close();
        return items;
    }

    public void insert(InfoItemModel item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(item);
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

    public InfoItemModel findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(InfoItemModel.class, id);
        } finally {
            em.close();
        }
    }

    public void update(InfoItemModel item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(item);
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

    public void delete(InfoItemModel item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(em.contains(item) ? item : em.merge(item));
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
