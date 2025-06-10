package com.ejemplo.jpa.service;

import com.ejemplo.jpa.model.Pais;
import com.ejemplo.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class PaisService {

    public void insertarPaisesIniciales() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Long count = em.createQuery("SELECT COUNT(p) FROM Pais p", Long.class).getSingleResult();
            if (count == 0) {
                em.persist(new Pais("Ecuador", LocalDate.now(), "admin", "ACTIVO"));
                em.persist(new Pais("Colombia", LocalDate.now(), "admin", "ACTIVO"));
                em.persist(new Pais("Perú", LocalDate.now(), "admin", "ACTIVO"));
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Pais> listarPaises() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            TypedQuery<Pais> query = em.createQuery("SELECT p FROM Pais p", Pais.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
