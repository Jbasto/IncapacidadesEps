/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.EstadoIncapacidadDto;
import edu.uniciencia.incapacidades.dto.IncapacidadesDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import edu.uniciencia.incapacidades.dto.TipoIncapacidadDto;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author basto
 */
@Local
public interface IncapacidadesEjbFormBeanLocal {

    String getTipoIncapacidades(int idTipo);

    String getEstadoIncapacidad(int idEstado);

    String getPacienteCita(int idCita);

    List<IncapacidadesDto> getIncapacidades();

    List<PacienteDto> getPacientesCita();

    List<TipoIncapacidadDto> getTipoIncapacidades();

    List<EstadoIncapacidadDto> getEstadoIncapacidades();

    int getIdIncapacidad();

    int getIdTipoIncapacidad(String nombre);

    int getIdEstadoIncapacidad(String nombre);

    boolean insertIncapacidad(Date fechaInicio, Date fechaFin, String tipoIncapacidad, String estadoIncapacidad, String citaPaciente);

    boolean updateIncapacidadPorId(int idIncapacidad, Date fechaInicio, Date fechaFin, String tipoIncapacidad, String estadoIncapacidad, String citaPaciente);
    
    boolean deleteIncapacidadPorID(int id);
}
