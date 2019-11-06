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
@Table(name = "eps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eps.findAll", query = "SELECT e FROM Eps e")
    , @NamedQuery(name = "Eps.findByPkIdEps", query = "SELECT e FROM Eps e WHERE e.pkIdEps = :pkIdEps")
    , @NamedQuery(name = "Eps.findByEpsNombre", query = "SELECT e FROM Eps e WHERE e.epsNombre = :epsNombre")
    , @NamedQuery(name = "Eps.findByEpsNit", query = "SELECT e FROM Eps e WHERE e.epsNit = :epsNit")})
public class Eps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_eps")
    private Integer pkIdEps;
    @Size(max = 300)
    @Column(name = "eps_nombre")
    private String epsNombre;
    @Size(max = 100)
    @Column(name = "eps_nit")
    private String epsNit;

    public Eps() {
    }

    public Eps(Integer pkIdEps) {
        this.pkIdEps = pkIdEps;
    }

    public Integer getPkIdEps() {
        return pkIdEps;
    }

    public void setPkIdEps(Integer pkIdEps) {
        this.pkIdEps = pkIdEps;
    }

    public String getEpsNombre() {
        return epsNombre;
    }

    public void setEpsNombre(String epsNombre) {
        this.epsNombre = epsNombre;
    }

    public String getEpsNit() {
        return epsNit;
    }

    public void setEpsNit(String epsNit) {
        this.epsNit = epsNit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdEps != null ? pkIdEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eps)) {
            return false;
        }
        Eps other = (Eps) object;
        if ((this.pkIdEps == null && other.pkIdEps != null) || (this.pkIdEps != null && !this.pkIdEps.equals(other.pkIdEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.Eps[ pkIdEps=" + pkIdEps + " ]";
    }
    
}
