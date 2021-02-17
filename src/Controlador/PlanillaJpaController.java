/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import modelos.Planilla;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelos.Torneo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class PlanillaJpaController implements Serializable {

    public PlanillaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PlanillaJpaController() {
        emf = Persistence.createEntityManagerFactory("PerfilUsuarioPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Planilla planilla) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo torneo = planilla.getTorneo();
            if (torneo != null) {
                torneo = em.getReference(torneo.getClass(), torneo.getId_tor());
                planilla.setTorneo(torneo);
            }
            em.persist(planilla);
            if (torneo != null) {
                torneo.getListaPlanillas().add(planilla);
                torneo = em.merge(torneo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Planilla planilla) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Planilla persistentPlanilla = em.find(Planilla.class, planilla.getId_plani());
            Torneo torneoOld = persistentPlanilla.getTorneo();
            Torneo torneoNew = planilla.getTorneo();
            if (torneoNew != null) {
                torneoNew = em.getReference(torneoNew.getClass(), torneoNew.getId_tor());
                planilla.setTorneo(torneoNew);
            }
            planilla = em.merge(planilla);
            if (torneoOld != null && !torneoOld.equals(torneoNew)) {
                torneoOld.getListaPlanillas().remove(planilla);
                torneoOld = em.merge(torneoOld);
            }
            if (torneoNew != null && !torneoNew.equals(torneoOld)) {
                torneoNew.getListaPlanillas().add(planilla);
                torneoNew = em.merge(torneoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = planilla.getId_plani();
                if (findPlanilla(id) == null) {
                    throw new NonexistentEntityException("The planilla with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Planilla planilla;
            try {
                planilla = em.getReference(Planilla.class, id);
                planilla.getId_plani();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The planilla with id " + id + " no longer exists.", enfe);
            }
            Torneo torneo = planilla.getTorneo();
            if (torneo != null) {
                torneo.getListaPlanillas().remove(planilla);
                torneo = em.merge(torneo);
            }
            em.remove(planilla);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Planilla> findPlanillaEntities() {
        return findPlanillaEntities(true, -1, -1);
    }

    public List<Planilla> findPlanillaEntities(int maxResults, int firstResult) {
        return findPlanillaEntities(false, maxResults, firstResult);
    }

    private List<Planilla> findPlanillaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Planilla.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Planilla findPlanilla(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Planilla.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlanillaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Planilla> rt = cq.from(Planilla.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
