/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.FuncionarioDto;
import edu.uniciencia.incapacidades.dto.TipoDocumentoDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author basto
 */
@Local
public interface FuncionarioEjbFormBeanLocal {

    boolean validarFuncionario(String documento, String contrasena);

    boolean insertFuncionario(String nombres, String apellidos, int tipoDocumento, String documento, String correo, String telefono, String contrasena);

    List<TipoDocumentoDto> getTipoDocumento();

    boolean validarDocumento(String documento);

    int getIdFuncionario();
    
    List<FuncionarioDto> getListFuncionarioDto();
    
    boolean deletePacientePorID(int idFuncionario);
    
    boolean updatePacientePorId(int id, String nombre, String apellidos, String tipoDoc, String documento, String correo, String telefono, String contrasena);
}
