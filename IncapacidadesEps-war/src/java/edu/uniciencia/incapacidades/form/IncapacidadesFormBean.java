/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.dto.EstadoIncapacidadDto;
import edu.uniciencia.incapacidades.dto.IncapacidadesDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import edu.uniciencia.incapacidades.dto.TipoIncapacidadDto;
import edu.uniciencia.incapacidades.ejb.beans.IncapacidadesEjbFormBeanLocal;
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
@Named(value = "incapacidadesFormBean")
@ManagedBean
@ApplicationScoped
public class IncapacidadesFormBean {

    @EJB
    private IncapacidadesEjbFormBeanLocal incapacidadesEjbFormBean;

    List<IncapacidadesDto> listaIncapacidadesDto = new ArrayList<>();
    List<EstadoIncapacidadDto> listaEstadoIncapacidadDto = new ArrayList<>();
    List<TipoIncapacidadDto> listaTipoIncapacidadDto = new ArrayList<>();
    List<PacienteDto> listaPacienteCitaDto = new ArrayList();

    int pkIdIncapacidad;
    Date incapacidadFechaInicio, incapacidadFechaFin;
    String citaNombre, tipoIncapacidad, estadoIncapacidad;
    IncapacidadesDto incapcidadSelect;

    public IncapacidadesFormBean() {
    }

    @PostConstruct
    public void init() {
        getListaIncapacidadesDto();
        getListaTipoIncapacidadDto();
        getListaEstadoIncapacidadDto();
        getListaPacienteCitaDto();
    }

    public List<IncapacidadesDto> getListaIncapacidadesDto() {
        listaIncapacidadesDto = incapacidadesEjbFormBean.getIncapacidades();
        return listaIncapacidadesDto;
    }

    public void setListaIncapacidadesDto(List<IncapacidadesDto> listaIncapacidadesDto) {
        this.listaIncapacidadesDto = listaIncapacidadesDto;
    }

    public List<EstadoIncapacidadDto> getListaEstadoIncapacidadDto() {
        listaEstadoIncapacidadDto = incapacidadesEjbFormBean.getEstadoIncapacidades();
        return listaEstadoIncapacidadDto;
    }

    public void setListaEstadoIncapacidadDto(List<EstadoIncapacidadDto> listaEstadoIncapacidadDto) {
        this.listaEstadoIncapacidadDto = listaEstadoIncapacidadDto;
    }

    public List<TipoIncapacidadDto> getListaTipoIncapacidadDto() {
        listaTipoIncapacidadDto = incapacidadesEjbFormBean.getTipoIncapacidades();
        return listaTipoIncapacidadDto;
    }

    public List<PacienteDto> getListaPacienteCitaDto() {
        listaPacienteCitaDto = incapacidadesEjbFormBean.getPacientesCita();
        return listaPacienteCitaDto;
    }

    public void setListaPacienteCitaDto(List<PacienteDto> listaPacienteCitaDto) {
        this.listaPacienteCitaDto = listaPacienteCitaDto;
    }

    public void setListaTipoIncapacidadDto(List<TipoIncapacidadDto> listaTipoIncapacidadDto) {
        this.listaTipoIncapacidadDto = listaTipoIncapacidadDto;
    }

    public int getPkIdIncapacidad() {
        return pkIdIncapacidad;
    }

    public void setPkIdIncapacidad(int pkIdIncapacidad) {
        this.pkIdIncapacidad = pkIdIncapacidad;
    }

    public Date getIncapacidadFechaInicio() {
        return incapacidadFechaInicio;
    }

    public void setIncapacidadFechaInicio(Date incapacidadFechaInicio) {
        this.incapacidadFechaInicio = incapacidadFechaInicio;
    }

    public Date getIncapacidadFechaFin() {
        return incapacidadFechaFin;
    }

    public void setIncapacidadFechaFin(Date incapacidadFechaFin) {
        this.incapacidadFechaFin = incapacidadFechaFin;
    }

    public String getCitaNombre() {
        return citaNombre;
    }

    public void setCitaNombre(String citaNombre) {
        this.citaNombre = citaNombre;
    }

    public String getTipoIncapacidad() {
        return tipoIncapacidad;
    }

    public void setTipoIncapacidad(String tipoIncapacidad) {
        this.tipoIncapacidad = tipoIncapacidad;
    }

    public String getEstadoIncapacidad() {
        return estadoIncapacidad;
    }

    public void setEstadoIncapacidad(String estadoIncapacidad) {
        this.estadoIncapacidad = estadoIncapacidad;
    }

    public IncapacidadesDto getIncapcidadSelect() {
        return incapcidadSelect;
    }

    public void setIncapcidadSelect(IncapacidadesDto incapcidadSelect) {
        this.incapcidadSelect = incapcidadSelect;
    }

    public String registrarIncapacidad() {
        if (incapacidadFechaInicio == null && incapacidadFechaFin == null) {
            Util.addErrorMessage("Los datos son obligatorios.");
        } else {

            boolean insert = incapacidadesEjbFormBean.insertIncapacidad(incapacidadFechaInicio, incapacidadFechaFin, tipoIncapacidad, estadoIncapacidad, citaNombre);

            if (insert) {
                incapacidadFechaInicio = null;
                incapacidadFechaFin = null;                
                Util.addSuccessMessage("Registro Correcto!");
            } else {
                Util.addErrorMessage("Ha ocurrido un error al guardar, inténtelo de nuevo.");
            }
        }
        return null;
    }
    
    public String editarIncapacidad() {        
        if (incapacidadesEjbFormBean.updateIncapacidadPorId(incapcidadSelect.getPkIdIncapacidad(), 
                incapcidadSelect.getIncapacidadFechaInicio(), 
                incapcidadSelect.getIncapacidadFechaFin(), 
                incapcidadSelect.getTipoIncapacidad(), 
                incapcidadSelect.getEstadoIncapacidad(), 
                incapcidadSelect.getCitaNombre())){
            return "faces/incapacidades.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
    
    public String borrarIncapacidadPorId(int idIncapacidad) {
        if (incapacidadesEjbFormBean.deleteIncapacidadPorID(idIncapacidad)){
            return "faces/incapacidades.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
}
