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
public class NodoJugador {
    Jugador jugador;
    NodoJugador siquiente;

    public NodoJugador() {
        this.jugador = jugador;
        this.siquiente = siquiente;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public NodoJugador getSiquiente() {
        return siquiente;
    }

    public void setSiquiente(NodoJugador siquiente) {
        this.siquiente = siquiente;
    }
    
    
    
}
