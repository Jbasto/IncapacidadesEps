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
@Table(name = "tipo_incapacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIncapacidad.findAll", query = "SELECT t FROM TipoIncapacidad t")
    , @NamedQuery(name = "TipoIncapacidad.findByPkIdTipoIncapacidad", query = "SELECT t FROM TipoIncapacidad t WHERE t.pkIdTipoIncapacidad = :pkIdTipoIncapacidad")
    , @NamedQuery(name = "TipoIncapacidad.findByTipoIncapacidadDescripcion", query = "SELECT t FROM TipoIncapacidad t WHERE t.tipoIncapacidadDescripcion = :tipoIncapacidadDescripcion")
    , @NamedQuery(name = "TipoIncapacidad.findByTipoIncapacidadDuracion", query = "SELECT t FROM TipoIncapacidad t WHERE t.tipoIncapacidadDuracion = :tipoIncapacidadDuracion")})
public class TipoIncapacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_tipo_incapacidad")
    private Integer pkIdTipoIncapacidad;
    @Size(max = 45)
    @Column(name = "tipo_incapacidad_descripcion")
    private String tipoIncapacidadDescripcion;
    @Size(max = 45)
    @Column(name = "tipo_incapacidad_duracion")
    private String tipoIncapacidadDuracion;

    public TipoIncapacidad() {
    }

    public TipoIncapacidad(Integer pkIdTipoIncapacidad) {
        this.pkIdTipoIncapacidad = pkIdTipoIncapacidad;
    }

    public Integer getPkIdTipoIncapacidad() {
        return pkIdTipoIncapacidad;
    }

    public void setPkIdTipoIncapacidad(Integer pkIdTipoIncapacidad) {
        this.pkIdTipoIncapacidad = pkIdTipoIncapacidad;
    }

    public String getTipoIncapacidadDescripcion() {
        return tipoIncapacidadDescripcion;
    }

    public void setTipoIncapacidadDescripcion(String tipoIncapacidadDescripcion) {
        this.tipoIncapacidadDescripcion = tipoIncapacidadDescripcion;
    }

    public String getTipoIncapacidadDuracion() {
        return tipoIncapacidadDuracion;
    }

    public void setTipoIncapacidadDuracion(String tipoIncapacidadDuracion) {
        this.tipoIncapacidadDuracion = tipoIncapacidadDuracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoIncapacidad != null ? pkIdTipoIncapacidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIncapacidad)) {
            return false;
        }
        TipoIncapacidad other = (TipoIncapacidad) object;
        if ((this.pkIdTipoIncapacidad == null && other.pkIdTipoIncapacidad != null) || (this.pkIdTipoIncapacidad != null && !this.pkIdTipoIncapacidad.equals(other.pkIdTipoIncapacidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.TipoIncapacidad[ pkIdTipoIncapacidad=" + pkIdTipoIncapacidad + " ]";
    }
    
}
