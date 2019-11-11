/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.CitaDto;
import edu.uniciencia.incapacidades.dto.FuncionarioDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import edu.uniciencia.incapacidades.ejb.persistentes.Cita;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author basto
 */
@Local
public interface CitaEjbFormBeanLocal {

    List<CitaDto> getCitas();

    String getFuncionarioNombre(int idFuncionario);

    String getPacienteNombre(int idPaciente);

    List<FuncionarioDto> getListFuncionarios();

    List<PacienteDto> getListPaciente();

    boolean insertCita(int idFuncionario, int idPaciente, Date horaProgramada, Date horaAtencion, String descripcion, boolean aplicaIncapacidad);
    
    int getIdCita();

    boolean deleteCitaPorID(int idCita);

    Cita getClientePorID(int id);

    boolean updateCitaPorId(int id, Date horaProgramada, Date horaAtencion, String descripcion, boolean aplicaIncapacidad);
        
}
