/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase Equipo donde se especifican los atributos 
 * que seran manejados 
 * @author Cristobal Rios 
 */
@Entity
@Table (name = "equipo")
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_equi;
    
    /* Se estable los datos que se manejaran dentro de la 
    base da datos
     */
    @Column(length = 50)
    private String nombreEquipo;
    @Column(length = 50)
    private String aliasEquipo;
    @Column(length = 50)
    private String entrenadorEquipo;
    /*Se establece la relacion entre las tablas identificando la tabla fuerte y la 
    debil*/
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "id_tor" , name = "id_Torneo")
    private Torneo torneo;
    
    /*añadimos la lista de objetos que dependen de la clase*/
    @OneToMany (mappedBy = "equipo",cascade = CascadeType.ALL)
    private List<Jugador> listaJugadores = new ArrayList<>();
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getAliasEquipo() {
        return aliasEquipo;
    }

    public void setAliasEquipo(String aliasEquipo) {
        this.aliasEquipo = aliasEquipo;
    }

    public String getEntrenadorEquipo() {
        return entrenadorEquipo;
    }

    public void setEntrenadorEquipo(String entrenadorEquipo) {
        this.entrenadorEquipo = entrenadorEquipo;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    
    public Long getId_equi() {
        return id_equi;
    }

    public void setId_equi(Long id_equi) {
        this.id_equi = id_equi;
    }

    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_equi != null ? id_equi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_equi fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id_equi == null && other.id_equi != null) || (this.id_equi != null && !this.id_equi.equals(other.id_equi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Equipo[ id=" + id_equi + " ]";
    }
    
}
