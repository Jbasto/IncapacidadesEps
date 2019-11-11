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
public class CitaDto {

    int pkIdCita; 
    Date citaHoraProgramada, citaHoraAtencion;
    String citaFuncionario, citaPaciente, citaDescripcion, citaAplicaIncapacidad;

    public CitaDto(int pkIdCita, Date citaHoraProgramada, Date citaHoraAtencion, String citaFuncionario, String citaPaciente, String citaDescripcion, String citaAplicaIncapacidad) {
        this.pkIdCita = pkIdCita;
        this.citaHoraProgramada = citaHoraProgramada;
        this.citaHoraAtencion = citaHoraAtencion;
        this.citaFuncionario = citaFuncionario;
        this.citaPaciente = citaPaciente;
        this.citaDescripcion = citaDescripcion;
        this.citaAplicaIncapacidad = citaAplicaIncapacidad;
    }
    
    public int getPkIdCita() {
        return pkIdCita;
    }

    public void setPkIdCita(int pkIdCita) {
        this.pkIdCita = pkIdCita;
    }

    public String getCitaFuncionario() {
        return citaFuncionario;
    }

    public void setCitaFuncionario(String citaFuncionario) {
        this.citaFuncionario = citaFuncionario;
    }

    public String getCitaPaciente() {
        return citaPaciente;
    }

    public void setCitaPaciente(String citaPaciente) {
        this.citaPaciente = citaPaciente;
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

    public String getCitaAplicaIncapacidad() {
        return citaAplicaIncapacidad;
    }

    public void setCitaAplicaIncapacidad(String citaAplicaIncapacidad) {
        this.citaAplicaIncapacidad = citaAplicaIncapacidad;
    }
}
