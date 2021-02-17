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
public class NodoPlanilla {
    Planilla planilla;
    NodoPlanilla siquiente;

    public NodoPlanilla() {
        this.planilla = planilla;
        this.siquiente = siquiente;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }
    
    public NodoPlanilla getSiquiente() {
        return siquiente;
    }

    public void setSiquiente(NodoPlanilla siquiente) {
        this.siquiente = siquiente;
    }
    
    
    
}
