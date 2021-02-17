/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table (name = "jugador")
public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_juga;

    /*datos del jugador*/
    @Column(length = 50)
    private String nombreJugador;
    @Column(length = 50)
    private String apellidoJugador;
    @Column(length = 50)
    private String numeroCjugador;
    @Column(length = 10)
    private String edad;
    @Column(length = 10)
    private String numeroTelefonico;
    @Column(length = 10)
    private String numeroCamiseta;
    @Column(length = 50)
    private String posicion;

    /*dependencia de la tabla equipo*/
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(referencedColumnName = "id_equi", name = "id_Equipo")
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public String getNumeroCjugador() {
        return numeroCjugador;
    }

    public void setNumeroCjugador(String numeroCjugador) {
        this.numeroCjugador = numeroCjugador;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(String numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    
    
    public Long getId_juga() {
        return id_juga;
    }

    public void setId_juga(Long id_juga) {
        this.id_juga = id_juga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_juga != null ? id_juga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_juga fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id_juga == null && other.id_juga != null) || (this.id_juga != null && !this.id_juga.equals(other.id_juga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Jugador[ id=" + id_juga + " ]";
    }
    
}
