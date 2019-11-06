/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.persistentes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author basto
 */
@Entity
@Table(name = "incapacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incapacidad.findAll", query = "SELECT i FROM Incapacidad i")
    , @NamedQuery(name = "Incapacidad.findByPkIdIncapacidad", query = "SELECT i FROM Incapacidad i WHERE i.pkIdIncapacidad = :pkIdIncapacidad")
    , @NamedQuery(name = "Incapacidad.findByIncapacidadFechaInicio", query = "SELECT i FROM Incapacidad i WHERE i.incapacidadFechaInicio = :incapacidadFechaInicio")
    , @NamedQuery(name = "Incapacidad.findByIncapacidadFechaFin", query = "SELECT i FROM Incapacidad i WHERE i.incapacidadFechaFin = :incapacidadFechaFin")
    , @NamedQuery(name = "Incapacidad.findByFkIdTipoIncapacidad", query = "SELECT i FROM Incapacidad i WHERE i.fkIdTipoIncapacidad = :fkIdTipoIncapacidad")
    , @NamedQuery(name = "Incapacidad.findByFkIdEstadoIncapacidad", query = "SELECT i FROM Incapacidad i WHERE i.fkIdEstadoIncapacidad = :fkIdEstadoIncapacidad")
    , @NamedQuery(name = "Incapacidad.findByFkIdCita", query = "SELECT i FROM Incapacidad i WHERE i.fkIdCita = :fkIdCita")})
public class Incapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_incapacidad")
    private Integer pkIdIncapacidad;
    @Column(name = "incapacidad_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date incapacidadFechaInicio;
    @Column(name = "incapacidad_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date incapacidadFechaFin;
    @Column(name = "fk_id_tipo_incapacidad")
    private Integer fkIdTipoIncapacidad;
    @Column(name = "fk_id_estado_incapacidad")
    private Integer fkIdEstadoIncapacidad;
    @Column(name = "fk_id_cita")
    private Integer fkIdCita;

    public Incapacidad() {
    }

    public Incapacidad(Integer pkIdIncapacidad) {
        this.pkIdIncapacidad = pkIdIncapacidad;
    }

    public Integer getPkIdIncapacidad() {
        return pkIdIncapacidad;
    }

    public void setPkIdIncapacidad(Integer pkIdIncapacidad) {
        this.pkIdIncapacidad = pkIdIncapacidad;
    }

    public Date getIncapacidadFechaInicio() {
        return incapacidadFechaInicio;
    }

    public void setIncapacidadFechaInicio(Date incapacidadFechaInicio) {
        this.incapacidadFechaInicio = incapacidadFechaInicio;
    }

    public Date getIncapacidadFechaFin() {
        return incapacidadFechaFin;
    }

    public void setIncapacidadFechaFin(Date incapacidadFechaFin) {
        this.incapacidadFechaFin = incapacidadFechaFin;
    }

    public Integer getFkIdTipoIncapacidad() {
        return fkIdTipoIncapacidad;
    }

    public void setFkIdTipoIncapacidad(Integer fkIdTipoIncapacidad) {
        this.fkIdTipoIncapacidad = fkIdTipoIncapacidad;
    }

    public Integer getFkIdEstadoIncapacidad() {
        return fkIdEstadoIncapacidad;
    }

    public void setFkIdEstadoIncapacidad(Integer fkIdEstadoIncapacidad) {
        this.fkIdEstadoIncapacidad = fkIdEstadoIncapacidad;
    }

    public Integer getFkIdCita() {
        return fkIdCita;
    }

    public void setFkIdCita(Integer fkIdCita) {
        this.fkIdCita = fkIdCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdIncapacidad != null ? pkIdIncapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incapacidad)) {
            return false;
        }
        Incapacidad other = (Incapacidad) object;
        if ((this.pkIdIncapacidad == null && other.pkIdIncapacidad != null) || (this.pkIdIncapacidad != null && !this.pkIdIncapacidad.equals(other.pkIdIncapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.Incapacidad[ pkIdIncapacidad=" + pkIdIncapacidad + " ]";
    }
    
}
