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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author basto
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByPkIdCita", query = "SELECT c FROM Cita c WHERE c.pkIdCita = :pkIdCita")
    , @NamedQuery(name = "Cita.findByFkIdFuncionario", query = "SELECT c FROM Cita c WHERE c.fkIdFuncionario = :fkIdFuncionario")
    , @NamedQuery(name = "Cita.findByFkIdPaciente", query = "SELECT c FROM Cita c WHERE c.fkIdPaciente = :fkIdPaciente")
    , @NamedQuery(name = "Cita.findByCitaHoraProgramada", query = "SELECT c FROM Cita c WHERE c.citaHoraProgramada = :citaHoraProgramada")
    , @NamedQuery(name = "Cita.findByCitaHoraAtencion", query = "SELECT c FROM Cita c WHERE c.citaHoraAtencion = :citaHoraAtencion")
    , @NamedQuery(name = "Cita.findByCitaDescripcion", query = "SELECT c FROM Cita c WHERE c.citaDescripcion = :citaDescripcion")
    , @NamedQuery(name = "Cita.findByCitaAplicaIncapacidad", query = "SELECT c FROM Cita c WHERE c.citaAplicaIncapacidad = :citaAplicaIncapacidad")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_id_cita")
    private Integer pkIdCita;
    @Column(name = "fk_id_funcionario")
    private Integer fkIdFuncionario;
    @Column(name = "fk_id_paciente")
    private Integer fkIdPaciente;
    @Column(name = "cita_hora_programada")
    @Temporal(TemporalType.DATE)
    private Date citaHoraProgramada;
    @Column(name = "cita_hora_atencion")
    @Temporal(TemporalType.DATE)
    private Date citaHoraAtencion;
    @Size(max = 200)
    @Column(name = "cita_descripcion")
    private String citaDescripcion;
    @Column(name = "cita_aplica_incapacidad")
    private Boolean citaAplicaIncapacidad;

    public Cita() {
    }

    public Cita(Integer pkIdCita) {
        this.pkIdCita = pkIdCita;
    }

    public Integer getPkIdCita() {
        return pkIdCita;
    }

    public void setPkIdCita(Integer pkIdCita) {
        this.pkIdCita = pkIdCita;
    }

    public Integer getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(Integer fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public Integer getFkIdPaciente() {
        return fkIdPaciente;
    }

    public void setFkIdPaciente(Integer fkIdPaciente) {
        this.fkIdPaciente = fkIdPaciente;
    }

    public Date getCitaHoraProgramada() {
        return citaHoraProgramada;
    }

    public void setCitaHoraProgramada(Date citaHoraProgramada) {
        this.citaHoraProgramada = citaHoraProgramada;
    }

    public Date getCitaHoraAtencion() {
        return citaHoraAtencion;
    }

    public void setCitaHoraAtencion(Date citaHoraAtencion) {
        this.citaHoraAtencion = citaHoraAtencion;
    }

    public String getCitaDescripcion() {
        return citaDescripcion;
    }

    public void setCitaDescripcion(String citaDescripcion) {
        this.citaDescripcion = citaDescripcion;
    }

    public Boolean getCitaAplicaIncapacidad() {
        return citaAplicaIncapacidad;
    }

    public void setCitaAplicaIncapacidad(Boolean citaAplicaIncapacidad) {
        this.citaAplicaIncapacidad = citaAplicaIncapacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCita != null ? pkIdCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.pkIdCita == null && other.pkIdCita != null) || (this.pkIdCita != null && !this.pkIdCita.equals(other.pkIdCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.Cita[ pkIdCita=" + pkIdCita + " ]";
    }
    
}
