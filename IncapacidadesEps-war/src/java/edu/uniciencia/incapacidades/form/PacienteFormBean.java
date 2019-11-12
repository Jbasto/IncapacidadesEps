/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.dto.EpsDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import edu.uniciencia.incapacidades.dto.TipoDocumentoDto;
import edu.uniciencia.incapacidades.ejb.beans.FuncionarioEjbFormBeanLocal;
import edu.uniciencia.incapacidades.ejb.beans.PacienteEjbFormBeanLocal;
import edu.uniciencia.incapacidades.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author basto
 */
@Named(value = "pacienteFormBean")
@ManagedBean
@ApplicationScoped
public class PacienteFormBean {

    @EJB
    private FuncionarioEjbFormBeanLocal funcionarioEjbFormBean;

    @EJB
    private PacienteEjbFormBeanLocal pacienteEjbFormBean;

    int pkIdPaciente;
    String pacienteNombres, pacienteApellidos, pacienteDocumento, epsPaciente, tipoDocumentoPaciente;
    PacienteDto pacienteSelect;
    List<TipoDocumentoDto> listaTipoDocumentoDto = new ArrayList<>();
    List<PacienteDto> listaPacienteDto = new ArrayList<>();
    List<EpsDto> listaEps = new ArrayList<>();

    /**
     * Creates a new instance of PacienteFormBean
     */
    public PacienteFormBean() {
    }

    @PostConstruct
    public void init() {
        getListaPacienteDto();
    }

    public int getPkIdPaciente() {
        return pkIdPaciente;
    }

    public void setPkIdPaciente(int pkIdPaciente) {
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

    public String getPacienteDocumento() {
        return pacienteDocumento;
    }

    public void setPacienteDocumento(String pacienteDocumento) {
        this.pacienteDocumento = pacienteDocumento;
    }

    public String getEpsPaciente() {
        return epsPaciente;
    }

    public void setEpsPaciente(String epsPaciente) {
        this.epsPaciente = epsPaciente;
    }

    public String getTipoDocumentoPaciente() {
        return tipoDocumentoPaciente;
    }

    public void setTipoDocumentoPaciente(String tipoDocumentoPaciente) {
        this.tipoDocumentoPaciente = tipoDocumentoPaciente;
    }

    public PacienteDto getPacienteSelect() {
        return pacienteSelect;
    }

    public void setPacienteSelect(PacienteDto pacienteSelect) {
        this.pacienteSelect = pacienteSelect;
    }

    public List<PacienteDto> getListaPacienteDto() {
        listaPacienteDto = pacienteEjbFormBean.getListPaciente();
        return listaPacienteDto;
    }

    public void setListaPacienteDto(List<PacienteDto> listaPacienteDto) {
        this.listaPacienteDto = listaPacienteDto;
    }

    public List<TipoDocumentoDto> getListaTipoDocumentoDto() {
        listaTipoDocumentoDto = funcionarioEjbFormBean.getTipoDocumento();
        return listaTipoDocumentoDto;
    }

    public void setListaTipoDocumentoDto(List<TipoDocumentoDto> listaTipoDocumentoDto) {
        this.listaTipoDocumentoDto = listaTipoDocumentoDto;
    }

    public List<EpsDto> getListaEps() {
        listaEps = pacienteEjbFormBean.getEps();
        return listaEps;
    }

    public void setListaEps(List<EpsDto> listaEps) {
        this.listaEps = listaEps;
    }

    public String registrarPaciente() {
        if (pacienteNombres == null || pacienteNombres.length() == 0
                && pacienteApellidos == null || pacienteApellidos.length() == 0
                && pacienteDocumento == null || pacienteDocumento.length() == 0) {

            Util.addErrorMessage("Los datos son obligatorios.");
        } else {

            boolean insert = pacienteEjbFormBean.insertPaciente(pacienteNombres, pacienteApellidos, tipoDocumentoPaciente, pacienteDocumento, epsPaciente);
            
            if (insert) {
                 limpiarVariables();
                Util.addSuccessMessage("Registro Correcto!");
            } else {
                Util.addErrorMessage("Ha ocurrido un error al guardar, inténtelo de nuevo.");
            }
        }       
        return null;
    }

    public void limpiarVariables() {
        this.pacienteNombres = "";
        this.pacienteApellidos = "";
        this.pacienteDocumento = "";
    }

    public String borrarPacientePorId(int idPaciente) {
        if (pacienteEjbFormBean.deletePacientePorID(idPaciente)){
            return "faces/pacientes.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String editarPaciente() {        
        if (pacienteEjbFormBean.updatePacientePorId(pacienteSelect.getPkIdPaciente(), pacienteSelect.getPacienteNombres(), pacienteSelect.getPacienteApellidos(), pacienteSelect.getTipoDocumentoPaciente(), pacienteSelect.getPacienteDocumento(), pacienteSelect.getEpsPaciente())) {
            return "faces/pacientes.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
}
