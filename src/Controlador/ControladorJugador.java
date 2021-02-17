/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelos.Jugador;
import modelos.NodoJugador;
import java.util.List;
import javax.swing.JOptionPane;
import org.jboss.logging.Logger;

/**
 * Clase que contiene un objeto del tipo JPA para llamar a los metodos 
 * de interaccion con la BD 
 * Clase que interactura directamente con la vista
 * @author Cristobal Rios 
 */
public class ControladorJugador {
    JugadorJpaController jugador = new JugadorJpaController();
    NodoJugador inicio;

    public ControladorJugador() {
        inicio = null;
    }
        
    public boolean vacio() {
        return inicio == null;
    }
   
     /*metodo para crear un nuevo Jugador*/
    public void crearJugador( Jugador juga){
        try {
            jugador.create(juga);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al crear equipo "+ ex);
        }
        
    }
    
     /*metodo para eliminar un nuevo Jugador*/
    public void eliminarJugador( Long id){
        try {
            jugador.destroy(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar torneo "+ ex);
        }
        
    }
    
     /*metodo para listar un nuevo Jugador*/
    public List<Jugador> listarJugador() {
        List<Jugador> listajuga = null;
        try {
            listajuga = jugador.findJugadorEntities();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber jugador " + ex);
        }  
        return listajuga;
    }
    
    
    public Jugador obtenerJugador(Long id) {
        Jugador juga = null;
        try {
            juga = jugador.findJugador(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber jugador " + ex);
        }
        return juga;
    }
    
      /**
     * 
     * @param nombre
     * @return Un objeto Jugador buscado por nombre && apellido
     */
    public Jugador obtenerJugadorEspecifico(String nombre, String ape) {
        List<Jugador> juga = null;
        Jugador j = null;
        juga = listarJugador();
        try {
            
            for (Jugador equi1 : juga) {       
                NodoJugador nuevo = new NodoJugador();
                nuevo.setJugador((Jugador)equi1);
                if (vacio()) {                    
                    inicio = nuevo;
                }else{
                    NodoJugador aux = inicio;
                    while(aux.getSiquiente()!=null){
                        aux = aux.getSiquiente();
                    }
                    aux.setSiquiente(nuevo);
                }
                
            }        
            /*una vez pasada la lista a una lista de nodos, buscamos dentro a traves del nombre && apellido*/
            NodoJugador auxi = inicio;
            boolean salir = false;
            
            while(auxi!=null && salir == false){
                if((String.valueOf(auxi.getJugador().getNombreJugador()).equalsIgnoreCase(nombre))
                        &&(String.valueOf(auxi.getJugador().getApellidoJugador()).equalsIgnoreCase(ape))){
                    Long id = auxi.getJugador().getId_juga();
                    j = obtenerJugador(id);
                    j.setId_juga(id);
                    
                    salir = true;
                }
                auxi = auxi.getSiquiente();
            }
            
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber equipo " + ex);
        }
        return j;
    }
}
