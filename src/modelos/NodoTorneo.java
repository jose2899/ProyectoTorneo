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
public class NodoTorneo {
    Torneo torneo;
    NodoTorneo siquiente;

    public NodoTorneo() {
        this.torneo = torneo;
        this.siquiente = siquiente;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    
    public NodoTorneo getSiquiente() {
        return siquiente;
    }

    public void setSiquiente(NodoTorneo siquiente) {
        this.siquiente = siquiente;
    }
    
    
    
}
