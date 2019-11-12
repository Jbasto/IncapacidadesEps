/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.dto;

/**
 *
 * @author basto
 */
public class FuncionarioDto {

    int pkIdFuncionario, fkIdTipoDocumentoFuncionario;
    String funcionarioNombres, funcionarioApellidos, funcionarioDocumento,
            funcionarioTelefono, funcionarioCorreo, funcionarioContrasena,
            tipoDocumento;

    public FuncionarioDto(int pkIdFuncionario, String funcionarioNombres) {
        this.pkIdFuncionario = pkIdFuncionario;
        this.funcionarioNombres = funcionarioNombres;       
    }

    public FuncionarioDto(int pkIdFuncionario, String funcionarioNombres, String funcionarioApellidos, String funcionarioDocumento, String funcionarioTelefono, String funcionarioCorreo, String funcionarioContrasena, String tipoDocumento) {
        this.pkIdFuncionario = pkIdFuncionario;
        this.funcionarioNombres = funcionarioNombres;
        this.funcionarioApellidos = funcionarioApellidos;
        this.funcionarioDocumento = funcionarioDocumento;
        this.funcionarioTelefono = funcionarioTelefono;
        this.funcionarioCorreo = funcionarioCorreo;
        this.funcionarioContrasena = funcionarioContrasena;
        this.tipoDocumento = tipoDocumento;
    }
          
    public int getPkIdFuncionario() {
        return pkIdFuncionario;
    }

    public void setPkIdFuncionario(int pkIdFuncionario) {
        this.pkIdFuncionario = pkIdFuncionario;
    }

    public int getFkIdTipoDocumentoFuncionario() {
        return fkIdTipoDocumentoFuncionario;
    }

    public void setFkIdTipoDocumentoFuncionario(int fkIdTipoDocumentoFuncionario) {
        this.fkIdTipoDocumentoFuncionario = fkIdTipoDocumentoFuncionario;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }    
}
