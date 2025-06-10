package com.example.tienda.dao;

import com.example.tienda.util.JPAUtil;
import com.example.tienda.model.AdmiPais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AdmiPaisDAO {

    public List<AdmiPais> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<AdmiPais> paises = em.createQuery("SELECT p FROM AdmiPais p", AdmiPais.class).getResultList();
        em.close();
        return paises;
    }

    public void insert(AdmiPais pais) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(pais);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void update(AdmiPais pais) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(pais);
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
