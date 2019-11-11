/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.dto.TipoDocumentoDto;
import edu.uniciencia.incapacidades.ejb.beans.FuncionarioEjbFormBeanLocal;
import edu.uniciencia.incapacidades.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author basto
 */
@ManagedBean
@ApplicationScoped
public class RegistroFormBean {

    @EJB
    private FuncionarioEjbFormBeanLocal funcionarioEjbFormBean;

    String nombresFuncionario, apellidosFuncionario, documentoFuncionario, correoFuncionario, telefonoFuncionario, contrasenaFuncionario;
    int tipoDocumento;
    List<TipoDocumentoDto> listaTipoDocumentoDto = new ArrayList<>();

    /**
     * Creates a new instance of RegistroFormBean
     */
    public RegistroFormBean() {

    }

    public String getNombresFuncionario() {
        return nombresFuncionario;
    }

    public void setNombresFuncionario(String nombresFuncionario) {
        this.nombresFuncionario = nombresFuncionario;
    }

    public String getApellidosFuncionario() {
        return apellidosFuncionario;
    }

    public void setApellidosFuncionario(String apellidosFuncionario) {
        this.apellidosFuncionario = apellidosFuncionario;
    }

    public String getDocumentoFuncionario() {
        return documentoFuncionario;
    }

    public void setDocumentoFuncionario(String documentoFuncionario) {
        this.documentoFuncionario = documentoFuncionario;
    }

    public String getCorreoFuncionario() {
        return correoFuncionario;
    }

    public void setCorreoFuncionario(String correoFuncionario) {
        this.correoFuncionario = correoFuncionario;
    }

    public String getTelefonoFuncionario() {
        return telefonoFuncionario;
    }

    public void setTelefonoFuncionario(String telefonoFuncionario) {
        this.telefonoFuncionario = telefonoFuncionario;
    }

    public String getContrasenaFuncionario() {
        return contrasenaFuncionario;
    }

    public void setContrasenaFuncionario(String contrasenaFuncionario) {
        this.contrasenaFuncionario = contrasenaFuncionario;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumentoDto> getListaTipoDocumentoDto() {
        return listaTipoDocumentoDto;
    }

    public void setListaTipoDocumentoDto(List<TipoDocumentoDto> listaTipoDocumentoDto) {
        this.listaTipoDocumentoDto = listaTipoDocumentoDto;
    }

    public List<TipoDocumentoDto> getTipoDocumentoDto() {       
        listaTipoDocumentoDto = funcionarioEjbFormBean.getTipoDocumento();
        return listaTipoDocumentoDto;
    }

    public String registrar() {
        if (documentoFuncionario == null || documentoFuncionario.length() == 0
                && nombresFuncionario == null || nombresFuncionario.length() == 0
                && apellidosFuncionario == null || apellidosFuncionario.length() == 0
                && documentoFuncionario == null || documentoFuncionario.length() == 0
                && correoFuncionario == null || correoFuncionario.length() == 0
                && telefonoFuncionario == null || telefonoFuncionario.length() == 0
                && contrasenaFuncionario == null || contrasenaFuncionario.length() == 0) {

            Util.addErrorMessage("Los datos de registro son obligatorios.");
        } else {
            boolean insert = funcionarioEjbFormBean.insertFuncionario(nombresFuncionario, apellidosFuncionario, tipoDocumento, documentoFuncionario, correoFuncionario, telefonoFuncionario, contrasenaFuncionario);

            if (insert) {
                Util.addSuccessMessage("Registro Correcto!");
                nombresFuncionario = "";
                apellidosFuncionario = "";
                documentoFuncionario = "";
                correoFuncionario = "";
                telefonoFuncionario = "";
                contrasenaFuncionario = "";
            } else {
                Util.addErrorMessage("El registro no se pudo realizar puede ser que el usuario ya exista.");
            }
        }

        return null;
    }

    @PostConstruct
    public void init() {
        getTipoDocumentoDto();
    }

    public String volver() {
        return null;
    }
}
