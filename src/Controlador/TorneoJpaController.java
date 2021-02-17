/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelos.Equipo;
import modelos.Torneo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase del tipo entyti que permite obtener todos los metodos que permiten manejar los datos 
 * de la DB directamente desde el codigo 
 * @author Cristobal Rios
 */
public class TorneoJpaController implements Serializable {

    public TorneoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public TorneoJpaController() {
        emf = Persistence.createEntityManagerFactory("PerfilUsuarioPU");
        
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torneo torneo) {
        if (torneo.getListaEquipos() == null) {
            torneo.setListaEquipos(new ArrayList<Equipo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Equipo> attachedListaEquipos = new ArrayList<Equipo>();
            for (Equipo listaEquiposEquipoToAttach : torneo.getListaEquipos()) {
                listaEquiposEquipoToAttach = em.getReference(listaEquiposEquipoToAttach.getClass(), listaEquiposEquipoToAttach.getId_equi());
                attachedListaEquipos.add(listaEquiposEquipoToAttach);
            }
            torneo.setListaEquipos(attachedListaEquipos);
            em.persist(torneo);
            for (Equipo listaEquiposEquipo : torneo.getListaEquipos()) {
                Torneo oldTorneoOfListaEquiposEquipo = listaEquiposEquipo.getTorneo();
                listaEquiposEquipo.setTorneo(torneo);
                listaEquiposEquipo = em.merge(listaEquiposEquipo);
                if (oldTorneoOfListaEquiposEquipo != null) {
                    oldTorneoOfListaEquiposEquipo.getListaEquipos().remove(listaEquiposEquipo);
                    oldTorneoOfListaEquiposEquipo = em.merge(oldTorneoOfListaEquiposEquipo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Torneo torneo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo persistentTorneo = em.find(Torneo.class, torneo.getId_tor());
            List<Equipo> listaEquiposOld = persistentTorneo.getListaEquipos();
            List<Equipo> listaEquiposNew = torneo.getListaEquipos();
            List<Equipo> attachedListaEquiposNew = new ArrayList<Equipo>();
            for (Equipo listaEquiposNewEquipoToAttach : listaEquiposNew) {
                listaEquiposNewEquipoToAttach = em.getReference(listaEquiposNewEquipoToAttach.getClass(), listaEquiposNewEquipoToAttach.getId_equi());
                attachedListaEquiposNew.add(listaEquiposNewEquipoToAttach);
            }
            listaEquiposNew = attachedListaEquiposNew;
            torneo.setListaEquipos(listaEquiposNew);
            torneo = em.merge(torneo);
            for (Equipo listaEquiposOldEquipo : listaEquiposOld) {
                if (!listaEquiposNew.contains(listaEquiposOldEquipo)) {
                    listaEquiposOldEquipo.setTorneo(null);
                    listaEquiposOldEquipo = em.merge(listaEquiposOldEquipo);
                }
            }
            for (Equipo listaEquiposNewEquipo : listaEquiposNew) {
                if (!listaEquiposOld.contains(listaEquiposNewEquipo)) {
                    Torneo oldTorneoOfListaEquiposNewEquipo = listaEquiposNewEquipo.getTorneo();
                    listaEquiposNewEquipo.setTorneo(torneo);
                    listaEquiposNewEquipo = em.merge(listaEquiposNewEquipo);
                    if (oldTorneoOfListaEquiposNewEquipo != null && !oldTorneoOfListaEquiposNewEquipo.equals(torneo)) {
                        oldTorneoOfListaEquiposNewEquipo.getListaEquipos().remove(listaEquiposNewEquipo);
                        oldTorneoOfListaEquiposNewEquipo = em.merge(oldTorneoOfListaEquiposNewEquipo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = torneo.getId_tor();
                if (findTorneo(id) == null) {
                    throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.");
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
            Torneo torneo;
            try {
                torneo = em.getReference(Torneo.class, id);
                torneo.getId_tor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.", enfe);
            }
            List<Equipo> listaEquipos = torneo.getListaEquipos();
            for (Equipo listaEquiposEquipo : listaEquipos) {
                listaEquiposEquipo.setTorneo(null);
                listaEquiposEquipo = em.merge(listaEquiposEquipo);
            }
            em.remove(torneo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Torneo> findTorneoEntities() {
        return findTorneoEntities(true, -1, -1);
    }

    public List<Torneo> findTorneoEntities(int maxResults, int firstResult) {
        return findTorneoEntities(false, maxResults, firstResult);
    }

    private List<Torneo> findTorneoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torneo.class));
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

    public Torneo findTorneo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torneo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorneoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torneo> rt = cq.from(Torneo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
