/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "planilla")
public class Planilla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_plani;

    public Long getId_plani() {
        return id_plani;
    }

    public void setId_plani(Long id_plani) {
        this.id_plani = id_plani;
    }

    /* Se estable los datos que se manejaran dentro de la 
    base da datos
     */
    @Column(length = 50)
    private String nombreEquipo;
    @Column(length = 50)
    private String nombreEquipo1;
    @Column(length = 50)
    private String nombreArbitro;
    @Column(length = 50)
    private String lugar;
    @Column(length = 250)
    private String descripcion;
    @Column(length = 50)
    private String jugaPartido;
    @Column(length = 50)
    private String resultado;
    @Column(length = 50)
    private String resultado1;
    @Column(length = 50)
    private String ganador;

    
    /*Se establece la relacion entre las tablas identificando la tabla fuerte y la 
    debil*/
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "id_tor" , name = "id_Torneo")
    private Torneo torneo;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public void setNombreEquipo1(String nombreEquipo1) {
        this.nombreEquipo1 = nombreEquipo1;
    }

    public String getNombreArbitro() {
        return nombreArbitro;
    }

    public void setNombreArbitro(String nombreArbitro) {
        this.nombreArbitro = nombreArbitro;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getJugaPartido() {
        return jugaPartido;
    }

    public void setJugaPartido(String jugaPartido) {
        this.jugaPartido = jugaPartido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado1() {
        return resultado1;
    }

    public void setResultado1(String resultado1) {
        this.resultado1 = resultado1;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    
    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
     
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_plani != null ? id_plani.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_plani fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.id_plani == null && other.id_plani != null) || (this.id_plani != null && !this.id_plani.equals(other.id_plani))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Planilla[ id=" + id_plani + " ]";
    }
    
}
