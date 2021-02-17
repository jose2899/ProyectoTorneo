/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cristobal Rios
 */
@Entity
@Table(name = "torneo")
public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tor;
    
     /* Se estable los datos que se manejaran dentro de la 
    base da datos
     */
    @Column(length = 50)
    private String nombreTorneo;
    @Column(length = 50)
    private Integer numeroEquipos;

    /*Creamos una lista de los objetos que tiene dependencia de la clase*/
    /*se agrega la relacion*/
    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL)
    private List<Equipo> listaEquipos = new ArrayList<>();

    /*Creamos una lista de los objetos que tiene dependencia de la clase*/
    /*se agrega la relacion*/
    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL)
    private List<Planilla> listaPlanillas = new ArrayList<>();

    public List<Planilla> getListaPlanillas() {
        return listaPlanillas;
    }

    public void setListaPlanillas(List<Planilla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }
      
    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    
    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public Integer getNumeroEquipos() {
        return numeroEquipos;
    }

    public void setNumeroEquipos(Integer numeroEquipos) {
        this.numeroEquipos = numeroEquipos;
    }
    
    public Long getId_tor() {
        return id_tor;
    }

    public void setId_tor(Long id_tor) {
        this.id_tor = id_tor;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_tor != null ? id_tor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_tor fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.id_tor == null && other.id_tor != null) || (this.id_tor != null && !this.id_tor.equals(other.id_tor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Torneo[ id=" + id_tor + " ]";
    }
    
}
