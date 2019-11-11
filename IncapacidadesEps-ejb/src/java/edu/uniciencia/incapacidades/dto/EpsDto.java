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
public class EpsDto {

    int pkIdEps;
    String epsNombre, epsNit;

    public EpsDto(int pkIdEps, String epsNombre) {
        this.pkIdEps = pkIdEps;
        this.epsNombre = epsNombre;
    }

    public int getPkIdEps() {
        return pkIdEps;
    }

    public void setPkIdEps(int pkIdEps) {
        this.pkIdEps = pkIdEps;
    }

    public String getEpsNombre() {
        return epsNombre;
    }

    public void setEpsNombre(String epsNombre) {
        this.epsNombre = epsNombre;
    }

    public String getEpsNit() {
        return epsNit;
    }

    public void setEpsNit(String epsNit) {
        this.epsNit = epsNit;
    }
}
