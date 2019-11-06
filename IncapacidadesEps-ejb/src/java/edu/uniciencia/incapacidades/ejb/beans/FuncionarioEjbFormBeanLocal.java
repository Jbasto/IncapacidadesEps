/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import javax.ejb.Local;

/**
 *
 * @author basto
 */
@Local
public interface FuncionarioEjbFormBeanLocal {

    boolean validarFuncionario(String documento, String contrasena);

    String insertFuncionario(String nombres, String apellidos, int tipoDocumento, String documento, String correo, String telefono, String contrasena);
    
}
