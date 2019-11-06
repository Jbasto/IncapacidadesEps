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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByPkIdTipoDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.pkIdTipoDocumento = :pkIdTipoDocumento")
    , @NamedQuery(name = "TipoDocumento.findByTipoDocumentoDescripcion", query = "SELECT t FROM TipoDocumento t WHERE t.tipoDocumentoDescripcion = :tipoDocumentoDescripcion")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_tipo_documento")
    private Integer pkIdTipoDocumento;
    @Size(max = 100)
    @Column(name = "tipo_documento_descripcion")
    private String tipoDocumentoDescripcion;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer pkIdTipoDocumento) {
        this.pkIdTipoDocumento = pkIdTipoDocumento;
    }

    public Integer getPkIdTipoDocumento() {
        return pkIdTipoDocumento;
    }

    public void setPkIdTipoDocumento(Integer pkIdTipoDocumento) {
        this.pkIdTipoDocumento = pkIdTipoDocumento;
    }

    public String getTipoDocumentoDescripcion() {
        return tipoDocumentoDescripcion;
    }

    public void setTipoDocumentoDescripcion(String tipoDocumentoDescripcion) {
        this.tipoDocumentoDescripcion = tipoDocumentoDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdTipoDocumento != null ? pkIdTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.pkIdTipoDocumento == null && other.pkIdTipoDocumento != null) || (this.pkIdTipoDocumento != null && !this.pkIdTipoDocumento.equals(other.pkIdTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.TipoDocumento[ pkIdTipoDocumento=" + pkIdTipoDocumento + " ]";
    }
    
}
