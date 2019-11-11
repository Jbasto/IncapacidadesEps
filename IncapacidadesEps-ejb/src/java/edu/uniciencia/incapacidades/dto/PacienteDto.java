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
public class PacienteDto {

    int pkIdPaciente;
    String pacienteNombres, pacienteApellidos, pacienteDocumento, epsPaciente, tipoDocumentoPaciente;

    public PacienteDto(String pacienteNombres) {
        this.pacienteNombres = pacienteNombres;
    }

    public PacienteDto(int pkIdPaciente, String pacienteNombres) {
        this.pkIdPaciente = pkIdPaciente;
        this.pacienteNombres = pacienteNombres;
    }

    public PacienteDto(int pkIdPaciente, String epsPaciente, String pacienteNombres, String pacienteApellidos, String tipoDocumentoPaciente, String pacienteDocumento) {
        this.pkIdPaciente = pkIdPaciente;
        this.epsPaciente = epsPaciente;
        this.pacienteNombres = pacienteNombres;
        this.pacienteApellidos = pacienteApellidos;
        this.tipoDocumentoPaciente = tipoDocumentoPaciente;
        this.pacienteDocumento = pacienteDocumento;
    }
    
    public int getPkIdPaciente() {
        return pkIdPaciente;
    }

    public void setPkIdPaciente(int pkIdPaciente) {
        this.pkIdPaciente = pkIdPaciente;
    }

    public String getEpsPaciente() {
        return epsPaciente;
    }

    public void setEpsPaciente(String epsPaciente) {
        this.epsPaciente = epsPaciente;
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

    public String getTipoDocumentoPaciente() {
        return tipoDocumentoPaciente;
    }

    public void setTipoDocumentoPaciente(String tipoDocumentoPaciente) {
        this.tipoDocumentoPaciente = tipoDocumentoPaciente;
    }

    public String getPacienteDocumento() {
        return pacienteDocumento;
    }

    public void setPacienteDocumento(String pacienteDocumento) {
        this.pacienteDocumento = pacienteDocumento;
    }
    
    
}
