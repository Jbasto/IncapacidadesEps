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
public class EstadoIncapacidadDto {

    int pkIdEstadoIncapacidad;
    String estadoIncapacidadDescripcion;

    public EstadoIncapacidadDto(int pkIdEstadoIncapacidad, String estadoIncapacidadDescripcion) {
        this.pkIdEstadoIncapacidad = pkIdEstadoIncapacidad;
        this.estadoIncapacidadDescripcion = estadoIncapacidadDescripcion;
    }
    
    public int getPkIdEstadoIncapacidad() {
        return pkIdEstadoIncapacidad;
    }

    public void setPkIdEstadoIncapacidad(int pkIdEstadoIncapacidad) {
        this.pkIdEstadoIncapacidad = pkIdEstadoIncapacidad;
    }

    public String getEstadoIncapacidadDescripcion() {
        return estadoIncapacidadDescripcion;
    }

    public void setEstadoIncapacidadDescripcion(String estadoIncapacidadDescripcion) {
        this.estadoIncapacidadDescripcion = estadoIncapacidadDescripcion;
    }
}
