/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.util.Util;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import edu.uniciencia.incapacidades.ejb.beans.FuncionarioEjbFormBeanLocal;

/**
 *
 * @author basto
 */
@ManagedBean
@ApplicationScoped
public class LoginFormBean {

    @EJB
    private FuncionarioEjbFormBeanLocal loginEjbFormBean;

    /**
     * Creates a new instance of LoginFormBean
     */
    String documento, contrasena;

    public LoginFormBean() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String enviarAceptar() {
        boolean rta = loginEjbFormBean.validarFuncionario(documento, contrasena);
        //boolean rta = actorPeliculaEjbFormBean.buscarActorPelicula(idActor, idPelicula);

        if (documento == null || documento.length() == 0 && contrasena == null || contrasena.length() == 0) {
            Util.addErrorMessage("El documento y contraseña no pueden estar vacíos.");
            return null;
        } else if (rta) {
            return "/faces/index.xhtml?faces-redirect=true";
        } else {
            Util.addErrorMessage("Credenciales erróneas!");
            return null;
        }
    }

    public String registrar() {
        return "/faces/registro.xhtml?faces-redirect=true";
    }
}
