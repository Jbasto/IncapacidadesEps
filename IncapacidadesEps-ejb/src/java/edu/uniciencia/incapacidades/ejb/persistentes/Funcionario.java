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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByPkIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.pkIdFuncionario = :pkIdFuncionario")
    , @NamedQuery(name = "Funcionario.findByFuncionarioNombres", query = "SELECT f FROM Funcionario f WHERE f.funcionarioNombres = :funcionarioNombres")
    , @NamedQuery(name = "Funcionario.findByFuncionarioApellidos", query = "SELECT f FROM Funcionario f WHERE f.funcionarioApellidos = :funcionarioApellidos")
    , @NamedQuery(name = "Funcionario.findByFkIdTipoDocumentoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.fkIdTipoDocumentoFuncionario = :fkIdTipoDocumentoFuncionario")
    , @NamedQuery(name = "Funcionario.findByFuncionarioDocumento", query = "SELECT f FROM Funcionario f WHERE f.funcionarioDocumento = :funcionarioDocumento")
    , @NamedQuery(name = "Funcionario.findByFuncionarioTelefono", query = "SELECT f FROM Funcionario f WHERE f.funcionarioTelefono = :funcionarioTelefono")
    , @NamedQuery(name = "Funcionario.findByFuncionarioCorreo", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCorreo = :funcionarioCorreo")
    , @NamedQuery(name = "Funcionario.findByFuncionarioContrasena", query = "SELECT f FROM Funcionario f WHERE f.funcionarioContrasena = :funcionarioContrasena")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_funcionario")
    private Integer pkIdFuncionario;
    @Size(max = 100)
    @Column(name = "funcionario_nombres")
    private String funcionarioNombres;
    @Size(max = 100)
    @Column(name = "funcionario_apellidos")
    private String funcionarioApellidos;
    @Column(name = "fk_id_tipo_documento_funcionario")
    private Integer fkIdTipoDocumentoFuncionario;
    @Size(max = 45)
    @Column(name = "funcionario_documento")
    private String funcionarioDocumento;
    @Size(max = 45)
    @Column(name = "funcionario_telefono")
    private String funcionarioTelefono;
    @Size(max = 100)
    @Column(name = "funcionario_correo")
    private String funcionarioCorreo;
    @Size(max = 45)
    @Column(name = "funcionario_contrasena")
    private String funcionarioContrasena;

    public Funcionario() {
    }

    public Funcionario(Integer pkIdFuncionario) {
        this.pkIdFuncionario = pkIdFuncionario;
    }

    public Integer getPkIdFuncionario() {
        return pkIdFuncionario;
    }

    public void setPkIdFuncionario(Integer pkIdFuncionario) {
        this.pkIdFuncionario = pkIdFuncionario;
    }

    public String getFuncionarioNombres() {
        return funcionarioNombres;
    }

    public void setFuncionarioNombres(String funcionarioNombres) {
        this.funcionarioNombres = funcionarioNombres;
    }

    public String getFuncionarioApellidos() {
        return funcionarioApellidos;
    }

    public void setFuncionarioApellidos(String funcionarioApellidos) {
        this.funcionarioApellidos = funcionarioApellidos;
    }

    public Integer getFkIdTipoDocumentoFuncionario() {
        return fkIdTipoDocumentoFuncionario;
    }

    public void setFkIdTipoDocumentoFuncionario(Integer fkIdTipoDocumentoFuncionario) {
        this.fkIdTipoDocumentoFuncionario = fkIdTipoDocumentoFuncionario;
    }

    public String getFuncionarioDocumento() {
        return funcionarioDocumento;
    }

    public void setFuncionarioDocumento(String funcionarioDocumento) {
        this.funcionarioDocumento = funcionarioDocumento;
    }

    public String getFuncionarioTelefono() {
        return funcionarioTelefono;
    }

    public void setFuncionarioTelefono(String funcionarioTelefono) {
        this.funcionarioTelefono = funcionarioTelefono;
    }

    public String getFuncionarioCorreo() {
        return funcionarioCorreo;
    }

    public void setFuncionarioCorreo(String funcionarioCorreo) {
        this.funcionarioCorreo = funcionarioCorreo;
    }

    public String getFuncionarioContrasena() {
        return funcionarioContrasena;
    }

    public void setFuncionarioContrasena(String funcionarioContrasena) {
        this.funcionarioContrasena = funcionarioContrasena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdFuncionario != null ? pkIdFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.pkIdFuncionario == null && other.pkIdFuncionario != null) || (this.pkIdFuncionario != null && !this.pkIdFuncionario.equals(other.pkIdFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uniciencia.incapacidades.ejb.persistentes.Funcionario[ pkIdFuncionario=" + pkIdFuncionario + " ]";
    }
    
}
