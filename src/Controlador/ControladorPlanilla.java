/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import modelos.NodoPlanilla;
import modelos.Planilla;
import java.util.List;
import javax.swing.JOptionPane;
import Controlador.ControladorTorneo;

/**
 * Clase que contiene un objeto del tipo JPA para llamar a los metodos de
 * interaccion con la BD Clase que interactura directamente con la vista
 *
 * @author Cristobal Rios
 */
public class ControladorPlanilla extends OperacionesControl{
    PlanillaJpaController planilla = new PlanillaJpaController();
    ControladorTorneo cT = new ControladorTorneo();
    NodoPlanilla inicio;

    /*Variable que atrapa un objeto para pasar la id a la entidad debil*/
    public static Planilla id_Planilla;
    
    public ControladorPlanilla() {
        inicio = null;
    }
          
    public boolean vacio() {
        return inicio == null;
    }
    
    /*metodo para crear un nuevo Equipo*/
    public boolean crearPlanilla(Planilla plani) {
        boolean creo = false;
        try {
            planilla.create(plani);
            creo = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al crear planilla " + ex);
        }
        return creo;
    }
    /*metodo para eliminar un nuevo Equipo*/

    public boolean eliminarPlanilla(Long equi) {
        boolean elimino = false;

        try {
            planilla.destroy(equi);
            elimino = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar planilla " + ex);
        }
        return elimino;
    }

    public boolean editarPlanilla(Planilla plani) {
        boolean edi = false;
        try {
            planilla.edit(plani);
            edi = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar planilla " + ex);
        }
        return edi;
    }
    /*metodo para listar un nuevo Equipo*/

    public List<Planilla> listarPlanilla() {
        List<Planilla> listaPlanilla = null;
        try {
            listaPlanilla = planilla.findPlanillaEntities();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener planilla " + e);
        }
        return listaPlanilla;
    }

    public Planilla obtenerPlanilla(Long id) {
        Planilla equi = null;
        try {
            equi = planilla.findPlanilla(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber planilla " + ex);
        }
        return equi;
    }
    
      /**
     * 
     * @param nombre
     * @return Un objeto Planilla buscado por los nombres de las equipos enfrentados
     */
    public Planilla obtenerPlanillaespecifico(String nombre, String n1) {
        List<Planilla> plani = null;
        Planilla p = null;
        plani = listarPlanilla();
        try {
            
            for (Planilla equi1 : plani) {       
                NodoPlanilla nuevo = new NodoPlanilla();
                nuevo.setPlanilla((Planilla)equi1);
                if (vacio()) {                    
                    inicio = nuevo;
                }else{
                    NodoPlanilla aux = inicio;
                    while(aux.getSiquiente()!=null){
                        aux = aux.getSiquiente();
                    }
                    aux.setSiquiente(nuevo);
                }
                
            }        
            /*una vez pasada la lista a una lista de nodos, buscamos dentro a traves del nombre*/
            NodoPlanilla auxi = inicio;
            boolean salir = false;
            
            while(auxi!=null && salir == false){
                if((String.valueOf(auxi.getPlanilla().getNombreEquipo()).equalsIgnoreCase(nombre))
                        &&(String.valueOf(auxi.getPlanilla().getNombreEquipo1()).equalsIgnoreCase(nombre))){
                    Long id = auxi.getPlanilla().getId_plani();
                    p = obtenerPlanilla(id);
                    p.setId_plani(id);
                    
                    salir = true;
                }
                auxi = auxi.getSiquiente();
            }
            
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obteber equipo " + ex);
        }
        return p;
    }

      /**
     * 
     * @param nombre
     * @return comprobar que una planilla generada sea unica por los nombres de las equipos enfrentados
     */
    public boolean unicaPlanilla(String nombre, String n1) {
        boolean s = true;
        List<Planilla> plani = null;
        Planilla p = null;
        plani = listarPlanilla();
        try {
            
            for (Planilla equi1 : plani) {       
                NodoPlanilla nuevo = new NodoPlanilla();
                nuevo.setPlanilla((Planilla)equi1);
                if (vacio()) {                    
                    inicio = nuevo;
                }else{
                    NodoPlanilla aux = inicio;
                    while(aux.getSiquiente()!=null){
                        aux = aux.getSiquiente();
                    }
                    aux.setSiquiente(nuevo);
                }
                
            }        
            /*una vez pasada la lista a una lista de nodos, buscamos dentro a traves del nombre*/
            NodoPlanilla auxi = inicio;
            boolean salir = false;
            
            while(auxi!=null && salir == false){
                if((String.valueOf(auxi.getPlanilla().getNombreEquipo()).equalsIgnoreCase(nombre))
                        &&(String.valueOf(auxi.getPlanilla().getNombreEquipo1()).equalsIgnoreCase(n1))){                 
                    s = false;
                    salir = true;
                }
                auxi = auxi.getSiquiente();
            }
             while(auxi!=null && salir == false){
                if((String.valueOf(auxi.getPlanilla().getNombreEquipo()).equalsIgnoreCase(n1))
                        &&(String.valueOf(auxi.getPlanilla().getNombreEquipo1()).equalsIgnoreCase(nombre))){                 
                    s = false;
                    salir = true;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer cantidadPlanillas() {
       int cantidad =0;
        //sacamos la lista de equipos
        List<Planilla> listaP = null;
        try {
            listaP = listarPlanilla();
            
            for (Planilla listaP1 : listaP) {
                if(cT.id_tor.getId_tor() == listaP1.getTorneo().getId_tor()){
                    cantidad++;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener equipo " + ex);
        }
        return cantidad;
    }
    
    /**
     * 
     * @param numero
     * @return El factorial de un numero
     */
    public Integer factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }
    
    /*metodo que controla el ingreso de solo numero en el parametro que se pide*/
    public boolean soloNumeros(String num) {
        return num.matches("[0-9]*");
    }
}
