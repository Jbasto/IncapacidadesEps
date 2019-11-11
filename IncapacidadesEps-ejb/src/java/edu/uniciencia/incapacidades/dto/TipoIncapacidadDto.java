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
public class TipoIncapacidadDto {

    int pkIdTipoIncapacidad;
    String tipoIncapacidadDescripcion, tipoIncapacidadDuracion;

    public TipoIncapacidadDto(int pkIdTipoIncapacidad, String tipoIncapacidadDescripcion, String tipoIncapacidadDuracion) {
        this.pkIdTipoIncapacidad = pkIdTipoIncapacidad;
        this.tipoIncapacidadDescripcion = tipoIncapacidadDescripcion;
        this.tipoIncapacidadDuracion = tipoIncapacidadDuracion;
    }

    public int getPkIdTipoIncapacidad() {
        return pkIdTipoIncapacidad;
    }

    public void setPkIdTipoIncapacidad(int pkIdTipoIncapacidad) {
        this.pkIdTipoIncapacidad = pkIdTipoIncapacidad;
    }

    public String getTipoIncapacidadDescripcion() {
        return tipoIncapacidadDescripcion;
    }

    public void setTipoIncapacidadDescripcion(String tipoIncapacidadDescripcion) {
        this.tipoIncapacidadDescripcion = tipoIncapacidadDescripcion;
    }

    public String getTipoIncapacidadDuracion() {
        return tipoIncapacidadDuracion;
    }

    public void setTipoIncapacidadDuracion(String tipoIncapacidadDuracion) {
        this.tipoIncapacidadDuracion = tipoIncapacidadDuracion;
    }

}
