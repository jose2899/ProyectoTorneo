/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


/**
 * Clase Nodo con el dato que va a recibir y el nodo de referencia
 * @author Cristobal Rios
 */
public class NodoEquipo {
    Equipo equipo;
    NodoEquipo siquiente;

    public NodoEquipo() {
        this.equipo = equipo;
        this.siquiente = siquiente;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public NodoEquipo getSiquiente() {
        return siquiente;
    }

    public void setSiquiente(NodoEquipo siquiente) {
        this.siquiente = siquiente;
    }
    
    
    
}
