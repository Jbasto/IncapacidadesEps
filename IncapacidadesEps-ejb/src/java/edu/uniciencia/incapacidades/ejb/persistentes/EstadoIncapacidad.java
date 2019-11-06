/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.persistentes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author basto
 */
@Entity
@Table(name = "estado_incapacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoIncapacidad.findAll", query = "SELECT e FROM EstadoIncapacidad e")
    , @NamedQuery(name = "EstadoIncapacidad.findByPkIdEstadoIncapacidad", query = "SELECT e FROM EstadoIncapacidad e WHERE e.pkIdEstadoIncapacidad = :pkIdEstadoIncapacidad")
    , @NamedQuery(name = "EstadoIncapacidad.findByEstadoIncapacidadDescripcion", query = "SELECT e FROM EstadoIncapacidad e WHERE e.estadoIncapacidadDescripcion = :estadoIncapacidadDescripcion")})
public class EstadoIncapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_estado_incapacidad")
    private Integer pkIdEstadoIncapacidad;
    @Size(max = 45)
    @Column(name = "estado_incapacidad_descripcion")
    private String estadoIncapacidadDescripcion;

    public EstadoIncapacidad() {
    }

    public EstadoIncapacidad(Integer pkIdEstadoIncapacidad) {
        this.pkIdEstadoIncapacidad = pkIdEstadoIncapacidad;
    }

    public Integer getPkIdEstadoIncapacidad() {
        return pkIdEstadoIncapacidad;
    }

    public void setPkIdEstadoIncapacidad(Integer pkIdEstadoIncapacidad) {
        this.pkIdEstadoIncapacidad = pkIdEstadoIncapacidad;
    }

    public String getEstadoIncapacidadDescripcion() {
        return estadoIncapacidadDescripcion;
    }

    public void setEstadoIncapacidadDescripcion(String estadoIncapacidadDescripcion) {
        this.estadoIncapacidadDescripcion = estadoIncapacidadDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEstadoIncapacidad != null ? pkIdEstadoIncapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoIncapacidad)) {
            return false;
        }
        EstadoIncapacidad other = (EstadoIncapacidad) object;
        if ((this.pkIdEstadoIncapacidad == null && other.pkIdEstadoIncapacidad != null) || (this.pkIdEstadoIncapacidad != null && !this.pkIdEstadoIncapacidad.equals(other.pkIdEstadoIncapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.EstadoIncapacidad[ pkIdEstadoIncapacidad=" + pkIdEstadoIncapacidad + " ]";
    }
    
}
