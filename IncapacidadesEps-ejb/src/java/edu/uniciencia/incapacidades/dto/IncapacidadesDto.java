/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.dto;

import java.util.Date;

/**
 *
 * @author basto
 */
public class IncapacidadesDto {

    int pkIdIncapacidad;
    Date incapacidadFechaInicio, incapacidadFechaFin;
    String citaNombre, tipoIncapacidad, estadoIncapacidad;

    public IncapacidadesDto(int pkIdIncapacidad, Date incapacidadFechaInicio, Date incapacidadFechaFin, String citaNombre, String tipoIncapacidad, String estadoIncapacidad) {
        this.pkIdIncapacidad = pkIdIncapacidad;
        this.incapacidadFechaInicio = incapacidadFechaInicio;
        this.incapacidadFechaFin = incapacidadFechaFin;
        this.citaNombre = citaNombre;
        this.tipoIncapacidad = tipoIncapacidad;
        this.estadoIncapacidad = estadoIncapacidad;
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
}
