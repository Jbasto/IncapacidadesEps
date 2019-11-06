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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author basto
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByPkIdPaciente", query = "SELECT p FROM Paciente p WHERE p.pkIdPaciente = :pkIdPaciente")
    , @NamedQuery(name = "Paciente.findByPacienteNombres", query = "SELECT p FROM Paciente p WHERE p.pacienteNombres = :pacienteNombres")
    , @NamedQuery(name = "Paciente.findByPacienteApellidos", query = "SELECT p FROM Paciente p WHERE p.pacienteApellidos = :pacienteApellidos")
    , @NamedQuery(name = "Paciente.findByFkIdTipoDocumentoPaciente", query = "SELECT p FROM Paciente p WHERE p.fkIdTipoDocumentoPaciente = :fkIdTipoDocumentoPaciente")
    , @NamedQuery(name = "Paciente.findByPacienteDocumento", query = "SELECT p FROM Paciente p WHERE p.pacienteDocumento = :pacienteDocumento")
    , @NamedQuery(name = "Paciente.findByFkIdEpsPaciente", query = "SELECT p FROM Paciente p WHERE p.fkIdEpsPaciente = :fkIdEpsPaciente")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_paciente")
    private Integer pkIdPaciente;
    @Size(max = 100)
    @Column(name = "paciente_nombres")
    private String pacienteNombres;
    @Size(max = 100)
    @Column(name = "paciente_apellidos")
    private String pacienteApellidos;
    @Column(name = "fk_id_tipo_documento_paciente")
    private Integer fkIdTipoDocumentoPaciente;
    @Size(max = 100)
    @Column(name = "paciente_documento")
    private String pacienteDocumento;
    @Column(name = "fk_id_eps_paciente")
    private Integer fkIdEpsPaciente;

    public Paciente() {
    }

    public Paciente(Integer pkIdPaciente) {
        this.pkIdPaciente = pkIdPaciente;
    }

    public Integer getPkIdPaciente() {
        return pkIdPaciente;
    }

    public void setPkIdPaciente(Integer pkIdPaciente) {
        this.pkIdPaciente = pkIdPaciente;
    }

    public String getPacienteNombres() {
        return pacienteNombres;
    }

    public void setPacienteNombres(String pacienteNombres) {
        this.pacienteNombres = pacienteNombres;
    }

    public String getPacienteApellidos() {
        return pacienteApellidos;
    }

    public void setPacienteApellidos(String pacienteApellidos) {
        this.pacienteApellidos = pacienteApellidos;
    }

    public Integer getFkIdTipoDocumentoPaciente() {
        return fkIdTipoDocumentoPaciente;
    }

    public void setFkIdTipoDocumentoPaciente(Integer fkIdTipoDocumentoPaciente) {
        this.fkIdTipoDocumentoPaciente = fkIdTipoDocumentoPaciente;
    }

    public String getPacienteDocumento() {
        return pacienteDocumento;
    }

    public void setPacienteDocumento(String pacienteDocumento) {
        this.pacienteDocumento = pacienteDocumento;
    }

    public Integer getFkIdEpsPaciente() {
        return fkIdEpsPaciente;
    }

    public void setFkIdEpsPaciente(Integer fkIdEpsPaciente) {
        this.fkIdEpsPaciente = fkIdEpsPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdPaciente != null ? pkIdPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pkIdPaciente == null && other.pkIdPaciente != null) || (this.pkIdPaciente != null && !this.pkIdPaciente.equals(other.pkIdPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.Paciente[ pkIdPaciente=" + pkIdPaciente + " ]";
    }
    
}
