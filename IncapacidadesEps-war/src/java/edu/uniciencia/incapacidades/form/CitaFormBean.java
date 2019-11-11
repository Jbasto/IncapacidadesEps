/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.dto.CitaDto;
import edu.uniciencia.incapacidades.dto.FuncionarioDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import edu.uniciencia.incapacidades.ejb.beans.CitaEjbFormBeanLocal;
import edu.uniciencia.incapacidades.util.Util;
import java.util.ArrayList;
import java.util.Date;
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
@Named(value = "citaFormBean")
@ManagedBean
@ApplicationScoped
public class CitaFormBean {

    @EJB
    private CitaEjbFormBeanLocal citaEjbFormBean;

    int pkIdCita;
    Date citaHoraProgramada, citaHoraAtencion;
    int citaFuncionario, citaPaciente;
    String citaDescripcion;
    boolean citaAplicaIncapacidad;
    List<CitaDto> listaCitaDto = new ArrayList<>();
    List<FuncionarioDto> listaFuncionarioDto = new ArrayList<>();
    List<PacienteDto> listaPacienteDto = new ArrayList<>();
    String idEditar;
    CitaDto citaSelect;

    /**
     * Creates a new instance of CitaFormBean
     */
    public CitaFormBean() {
    }

    @PostConstruct
    public void init() {
        getListaCitaDto();
        getListaFuncionarioDto();
        getListaPacienteDto();
    }

    public CitaEjbFormBeanLocal getCitaEjbFormBean() {
        return citaEjbFormBean;
    }

    public void setCitaEjbFormBean(CitaEjbFormBeanLocal citaEjbFormBean) {
        this.citaEjbFormBean = citaEjbFormBean;
    }

    public int getPkIdCita() {
        return pkIdCita;
    }

    public void setPkIdCita(int pkIdCita) {
        this.pkIdCita = pkIdCita;
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

    public int getCitaFuncionario() {
        return citaFuncionario;
    }

    public void setCitaFuncionario(int citaFuncionario) {
        this.citaFuncionario = citaFuncionario;
    }

    public int getCitaPaciente() {
        return citaPaciente;
    }

    public void setCitaPaciente(int citaPaciente) {
        this.citaPaciente = citaPaciente;
    }

    public String getCitaDescripcion() {
        return citaDescripcion;
    }

    public void setCitaDescripcion(String citaDescripcion) {
        this.citaDescripcion = citaDescripcion;
    }

    public boolean isCitaAplicaIncapacidad() {
        return citaAplicaIncapacidad;
    }

    public void setCitaAplicaIncapacidad(boolean citaAplicaIncapacidad) {
        this.citaAplicaIncapacidad = citaAplicaIncapacidad;
    }

    public List<CitaDto> getListaCitaDto() {
        listaCitaDto = citaEjbFormBean.getCitas();
        return listaCitaDto;
    }

    public void setListaCitaDto(List<CitaDto> listaCitaDto) {
        this.listaCitaDto = listaCitaDto;
    }

    public List<FuncionarioDto> getListaFuncionarioDto() {
        listaFuncionarioDto = citaEjbFormBean.getListFuncionarios();
        return listaFuncionarioDto;
    }

    public void setListaFuncionarioDto(List<FuncionarioDto> listaFuncionarioDto) {
        this.listaFuncionarioDto = listaFuncionarioDto;
    }

    public List<PacienteDto> getListaPacienteDto() {
        listaPacienteDto = citaEjbFormBean.getListPaciente();
        return listaPacienteDto;
    }

    public void setListaPacienteDto(List<PacienteDto> listaPacienteDto) {
        this.listaPacienteDto = listaPacienteDto;
    }

    public String getIdEditar() {
        return idEditar;
    }

    public void setIdEditar(String idEditar) {
        this.idEditar = idEditar;
    }

    public CitaDto getCitaSelect() {
        return citaSelect;
    }

    public void setCitaSelect(CitaDto citaSelect) {
        this.citaSelect = citaSelect;
    }

    public String registrarCita() {
        if (citaHoraProgramada == null
                && citaHoraAtencion == null
                && citaDescripcion == null || citaDescripcion.length() == 0) {

            Util.addErrorMessage("Los datos son obligatorios.");
        } else {
            boolean insert = citaEjbFormBean.insertCita(citaFuncionario, citaPaciente, citaHoraProgramada, citaHoraAtencion, citaDescripcion, citaAplicaIncapacidad);

            if (insert) {
                Util.addSuccessMessage("Registro Correcto!");
            } else {
                Util.addErrorMessage("Ha ocurrido un error al guardar, inténtelo de nuevo.");
            }
        }

        limpiarVariables();
        return null;
    }

    public void limpiarVariables() {
        this.citaHoraProgramada = null;
        this.citaHoraAtencion = null;
        this.citaDescripcion = "";
        this.citaAplicaIncapacidad = false;
    }

    public String borrarCitaPorId(int idCita) {
        if (citaEjbFormBean.deleteCitaPorID(idCita)) {
            return "faces/citas.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String editarCita() {
        String aplicaIn = citaSelect.getCitaAplicaIncapacidad();
        boolean updateIncapacidad = false;
        if (aplicaIn.equalsIgnoreCase("TRUE")) {
            updateIncapacidad = true;
        }

        if (citaEjbFormBean.updateCitaPorId(citaSelect.getPkIdCita(), citaSelect.getCitaHoraProgramada(), citaSelect.getCitaHoraAtencion(), citaSelect.getCitaDescripcion(), updateIncapacidad)) {
            return "faces/citas.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
}
