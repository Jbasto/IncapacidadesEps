/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.EpsDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author basto
 */
@Local
public interface PacienteEjbFormBeanLocal {

    List<PacienteDto> getListPaciente();

    String getNombreEps(int idEps);

    String getNombreTipoDocumento(int idTipoDoc);

    List<EpsDto> getEps();

    int getIdPaciente();

    int getIdTipoDocumento(String nombre);

    int getIdEps(String nombre);
    
    boolean insertPaciente(String nombre, String apellidos, String tipoDocumento, String documento, String eps);

    boolean deletePacientePorID(int idCita);
    
    boolean updatePacientePorId(int id, String nombre, String apellidos, String tipoDoc, String documento, String epsNombre);    
    
}
