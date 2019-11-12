/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.dto.EpsDto;
import edu.uniciencia.incapacidades.ejb.beans.EpsEjbFormBeanLocal;
import edu.uniciencia.incapacidades.ejb.beans.PacienteEjbFormBeanLocal;
import edu.uniciencia.incapacidades.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author JONATHANB
 */
@Named(value = "epsFormBean")
@ApplicationScoped
public class EpsFormBean {

    @EJB
    private EpsEjbFormBeanLocal epsEjbFormBean;

    /**
     * Creates a new instance of EpsFormBean
     */
    public EpsFormBean() {
    }

    int pkIdEps;
    String epsNombre, epsNit;
    List<EpsDto> listaEpsDto = new ArrayList<>();
    EpsDto epsSelect;

    @PostConstruct
    public void init() {
        getListaEpsDto();
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

    public List<EpsDto> getListaEpsDto() {
        listaEpsDto = epsEjbFormBean.getListaEps();
        return listaEpsDto;
    }

    public void setListaEpsDto(List<EpsDto> listaEpsDto) {
        this.listaEpsDto = listaEpsDto;
    }

    public EpsDto getEpsSelect() {
        return epsSelect;
    }

    public void setEpsSelect(EpsDto epsSelect) {
        this.epsSelect = epsSelect;
    }

    public String registrarEps() {
        if (epsNombre.length() == 0 && epsNit.length() == 0) {

            Util.addErrorMessage("Los datos son obligatorios.");
        } else {

            boolean insert = epsEjbFormBean.insertEps(epsNombre, epsNit);

            if (insert) {
                epsNombre = "";
                epsNit = "";
                Util.addSuccessMessage("Registro Correcto!");
            } else {
                Util.addErrorMessage("Ha ocurrido un error al guardar, inténtelo de nuevo.");
            }
        }
        return null;
    }

    public String borrarEpsPorId(int idEps) {
        if (epsEjbFormBean.deleteEpsPorID(idEps)) {
            return "faces/eps.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String editarEps() {
        if (epsEjbFormBean.updateEpsPorId(epsSelect.getPkIdEps(), epsSelect.getEpsNombre(), epsSelect.getEpsNit())) {
            return "faces/eps.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
}
