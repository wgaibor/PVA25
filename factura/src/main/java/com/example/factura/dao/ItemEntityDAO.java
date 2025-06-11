package com.example.factura.dao;

import com.example.factura.model.ItemModel;
import com.example.factura.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class ItemEntityDAO {

    public List<ItemModel> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<ItemModel> items = em.createQuery("SELECT i FROM ItemModel i", ItemModel.class).getResultList();
        em.close();
        return items;
    }

    public void insert(ItemModel item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(item);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void update(ItemModel item) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(item);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ItemModel item = em.find(ItemModel.class, id);
            if (item != null) {
                em.remove(item);
            }
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