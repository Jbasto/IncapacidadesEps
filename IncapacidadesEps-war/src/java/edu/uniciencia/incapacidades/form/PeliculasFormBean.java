/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

//import edu.uniciencia.prueba2.ejb.beans.ActorPeliculaEjbFormBeanLocal;
import edu.uniciencia.incapacidades.util.Util;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author basto
 */
@ManagedBean
@ApplicationScoped
public class PeliculasFormBean {

    //@EJB
    //private ActorPeliculaEjbFormBeanLocal actorPeliculaEjbFormBean;

    //@EJB
    //private PeliculasEjbFormBeanLocal peliculasEjbFormBean;

    int idActor, idPelicula;
    //String titulo, descripcion;

    public PeliculasFormBean() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public void enviarAceptar() {
        //boolean rta = peliculasEjbFormBean.actualizarPeliculaTexto(idPelicula, titulo, descripcion);
        //boolean rta = actorPeliculaEjbFormBean.buscarActorPelicula(idActor, idPelicula);
        
        //if (rta) {
       //     Util.addSuccessMessage("Todo OK");
        //} else {
        //   Util.addErrorMessage("Ha ocurrido un Error");
        //}
    }

}
