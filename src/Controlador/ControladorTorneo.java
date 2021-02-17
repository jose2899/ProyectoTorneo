/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelos.NodoTorneo;
import modelos.Torneo;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que contiene un objeto del tipo JPA para llamar a los metodos de
 * interaccion con la BD Clase que interactura directamente con la vista
 *
 * @author Cristobal Rios
 */
public class ControladorTorneo {

    TorneoJpaController torneo = new TorneoJpaController();
    NodoTorneo inicio;

    public static Integer numEquipos;

    
    public ControladorTorneo() {
        inicio = null;
    }
        
    public boolean vacio() {
        return inicio == null;
    }
    
     /*Variable que atrapa un objeto para pasar la id a la entidad debil*/
    public static Torneo id_tor;
    
    /*metodo para crear un nuevo Torneo*/
    public void crearTorneo(Torneo tor) {
        try {
            torneo.create(tor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al crear torneo " + ex);
        }

    }
    /*metodo para eliminar un nuevo Torneo*/

    public void eliminarTorneo(Long id) {
        try {
            torneo.destroy(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar torneo " + ex);
        }

    }

    /*metodo para listar un nuevo Torneo*/
    public List<Torneo> listarTorneo() {
        List<Torneo> listaTorneo = null;
        try {
            listaTorneo = torneo.findTorneoEntities();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obteber torneo " + e);
        }

        return listaTorneo;
    }
    
    //metodo para obtener un equipo en concreto
    public Torneo obtenerTorneo(Long id){
        Torneo tor = null;
        try {
            tor = torneo.findTorneo(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber torneo " + ex);
        }
        return tor;
    }
    
     /**
     * 
     * @param nombre
     * @return Un objeto Equipo buscado por nombre
     */
    public Torneo obtenerTorneoNombre(String nombre) {
        List<Torneo> torne = null;
        Torneo t = null;
        torne = listarTorneo();
        try {
            
            for (Torneo equi1 : torne) {       
                NodoTorneo nuevo = new NodoTorneo();
                nuevo.setTorneo((Torneo)equi1);
                if (vacio()) {                    
                    inicio = nuevo;
                }else{
                    NodoTorneo aux = inicio;
                    while(aux.getSiquiente()!=null){
                        aux = aux.getSiquiente();
                    }
                    aux.setSiquiente(nuevo);
                }
                
            }        
            /*una vez pasada la lista a una lista de nodos, buscamos dentro a traves del nombre*/
            NodoTorneo auxi = inicio;
            boolean salir = false;
            
            while(auxi!=null && salir == false){
                if(String.valueOf(auxi.getTorneo().getNombreTorneo()).equalsIgnoreCase(nombre)){
                    Long id = auxi.getTorneo().getId_tor();
                    t = obtenerTorneo(id);
                    t.setId_tor(id);
                    
                    salir = true;
                }
                auxi = auxi.getSiquiente();
            }
            
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber torneo " + ex);
        }
        return t;
    }
}
