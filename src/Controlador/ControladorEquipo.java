/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelos.Equipo;
import modelos.NodoEquipo;
import java.util.List;
import javax.swing.JOptionPane;
import Controlador.ControladorTorneo;

/**
 * Clase que contiene un objeto del tipo JPA para llamar a los metodos de
 * interaccion con la BD Clase que interactura directamente con la vista
 *
 * @author Cristobal Rios
 */
public class ControladorEquipo extends OperacionesControl{

    EquipoJpaController equipo = new EquipoJpaController();
    ControladorTorneo cT = new ControladorTorneo();
    NodoEquipo inicio;

    public ControladorEquipo() {
        inicio = null;
    }


    public boolean vacio() {
        return inicio == null;
    }

    /*Variable que atrapa un objeto para pasar la id a la entidad debil*/
    public static Equipo id_Equi;
    
    
    /*metodo para crear un nuevo Equipo*/
    public boolean crearEquipo(Equipo equi) {
        boolean creo = false;
        try {
            equipo.create(equi);
            creo = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al crear equipo " + ex);
        }
        return creo;
    }
    /*metodo para eliminar un nuevo Equipo*/

    public boolean eliminarEquipo(Long equi) {
        boolean elimino = false;

        try {
            equipo.destroy(equi);
            elimino = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar equipo " + ex);
        }
        return elimino;
    }

    public boolean editarEquipo(Equipo equip) {
        boolean edi = false;
        try {
            equipo.edit(equip);
            edi = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar equipo " + ex);
        }
        return edi;
    }
    /**
     * 
     * @return lista de equipos 
     */
    public List<Equipo> listarEquipo() {
        List<Equipo> listaequipos = null;
        try {
            listaequipos = equipo.findEquipoEntities();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener equipo " + e);
        }
        return listaequipos;
    }

    /**
     * 
     * @param id
     * @return Equipo objeto de la clase equipo
     */
    public Equipo obtenerEquipo(Long id) {
        Equipo equi = null;
        try {
            equi = equipo.findEquipo(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber equipo " + ex);
        }
        return equi;
    }
   
    /**
     * 
     * @param nombre
     * @return Un objeto Equipo buscado por nombre
     */
    public Equipo obtenerEquipoEspecifico(String nombre) {
        List<Equipo> equi = null;
        Equipo e = null;
        equi = listarEquipo();
        try {
            
            for (Equipo equi1 : equi) {       
                NodoEquipo nuevo = new NodoEquipo();
                nuevo.setEquipo((Equipo)equi1);
                if (vacio()) {                    
                    inicio = nuevo;
                }else{
                    NodoEquipo aux = inicio;
                    while(aux.getSiquiente()!=null){
                        aux = aux.getSiquiente();
                    }
                    aux.setSiquiente(nuevo);
                }
                
            }        
            /*una vez pasada la lista a una lista de nodos, buscamos dentro a traves del nombre*/
            NodoEquipo auxi = inicio;
            boolean salir = false;
            
            while(auxi!=null && salir == false){
                if(String.valueOf(auxi.getEquipo().getNombreEquipo()).equalsIgnoreCase(nombre)){
                    Long id = auxi.getEquipo().getId_equi();
                    e = obtenerEquipo(id);
                    e.setId_equi(id);
                    
                    salir = true;
                }
                auxi = auxi.getSiquiente();
            }
            
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber equipo " + ex);
        }
        return e;
    }

    /**
     * 
     * @param nombre
     * @return boolean false/true para comprobar si un registro de equipo es unico por el nombre 
     */
    public boolean unicoEquipo(String nombre){
        boolean s = true;
        List<Equipo> equi = null;
        equi = listarEquipo();
        try {
            
            for (Equipo equi1 : equi) {       
                NodoEquipo nuevo = new NodoEquipo();
                nuevo.setEquipo((Equipo)equi1);
                if (vacio()) {                    
                    inicio = nuevo;
                }else{
                    NodoEquipo aux = inicio;
                    while(aux.getSiquiente()!=null){
                        aux = aux.getSiquiente();
                    }
                    aux.setSiquiente(nuevo);
                }
                
            }        
            /*una vez pasada la lista a una lista de nodos, buscamos dentro a traves del nombre*/
            NodoEquipo auxi = inicio;
            boolean salir = false;
            
            while(auxi!=null && salir == false){
                if(String.valueOf(auxi.getEquipo().getNombreEquipo()).equalsIgnoreCase(nombre)){                   
                    salir = true;
                    s = false;
                }
                auxi = auxi.getSiquiente();
            }
            
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber equipo " + ex);
        }
        return s;
    }

    @Override
    public Integer cantidadEquipos() {
        int cantidad =0;
        //sacamos la lista de equipos
        List<Equipo> listaE = null;
        try {
            listaE = listarEquipo();
            
            for (Equipo listaE1 : listaE) {
                if(cT.id_tor.getId_tor() == listaE1.getTorneo().getId_tor()){
                    cantidad++;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener equipo " + ex);
        }
        return cantidad;
    }

    @Override
    public Integer cantidadPlanillas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
