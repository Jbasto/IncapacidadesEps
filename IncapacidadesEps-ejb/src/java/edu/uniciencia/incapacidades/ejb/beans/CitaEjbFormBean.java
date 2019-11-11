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
import edu.uniciencia.incapacidades.ejb.persistentes.Funcionario;
import edu.uniciencia.incapacidades.ejb.persistentes.Paciente;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author basto
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CitaEjbFormBean implements CitaEjbFormBeanLocal {

    @PersistenceContext(unitName = "IncapacidadesEps-ejbPU")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<CitaDto> getCitas() {
        List<CitaDto> listaCitasDtos = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM ");
            sql.append("Cita c ");
            Query query = em.createQuery(sql.toString());
            List<Cita> listaCitas = query.getResultList();
            query.getResultList();
            if (!listaCitas.isEmpty()) {
                listaCitas.forEach((citaEntity) -> {
                    String nombreFuncionario = getFuncionarioNombre(citaEntity.getFkIdFuncionario());
                    String nombrePaciente = getPacienteNombre(citaEntity.getFkIdPaciente());
                    String aplicaIncapacidad = "NO";

                    if (citaEntity.getCitaAplicaIncapacidad()) {
                        aplicaIncapacidad = "SI";
                    }

                    listaCitasDtos.add(
                            new CitaDto(citaEntity.getPkIdCita(),
                                    citaEntity.getCitaHoraProgramada(),
                                    citaEntity.getCitaHoraAtencion(),
                                    nombreFuncionario,
                                    nombrePaciente,
                                    citaEntity.getCitaDescripcion(),
                                    aplicaIncapacidad
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaCitasDtos;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String getFuncionarioNombre(int idFuncionario) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select CONCAT(f.funcionarioNombres, ' ', f.funcionarioApellidos) from ");
            sql.append(" Funcionario f ");
            sql.append(" where f.pkIdFuncionario =:id");
            mapa.put("id", idFuncionario);

            Query query = em.createQuery(sql.toString());

            for (Map.Entry<String, Object> m : mapa.entrySet()) {
                query.setParameter(m.getKey(), m.getValue());
            }

            String result = (String) query.getSingleResult();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPacienteNombre(int idPaciente) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select CONCAT(p.pacienteNombres , ' ', p.pacienteApellidos) from ");
            sql.append(" Paciente p ");
            sql.append(" where p.pkIdPaciente =:id");
            mapa.put("id", idPaciente);

            Query query = em.createQuery(sql.toString());

            for (Map.Entry<String, Object> m : mapa.entrySet()) {
                query.setParameter(m.getKey(), m.getValue());
            }

            String result = (String) query.getSingleResult();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<FuncionarioDto> getListFuncionarios() {
        List<FuncionarioDto> listaFuncionarios = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f FROM ");
            sql.append("Funcionario f ");
            Query query = em.createQuery(sql.toString());
            List<Funcionario> listaFuncionario = query.getResultList();
            query.getResultList();
            if (!listaFuncionario.isEmpty()) {
                listaFuncionario.forEach((funcionarioEntity) -> {
                    listaFuncionarios.add(
                            new FuncionarioDto(
                                    funcionarioEntity.getPkIdFuncionario(),
                                    funcionarioEntity.getFuncionarioNombres() + " " + funcionarioEntity.getFuncionarioApellidos()
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaFuncionarios;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<PacienteDto> getListPaciente() {
        List<PacienteDto> listaPacientes = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM ");
            sql.append("Paciente p ");
            Query query = em.createQuery(sql.toString());
            List<Paciente> listaPaciente = query.getResultList();
            query.getResultList();
            if (!listaPaciente.isEmpty()) {
                listaPaciente.forEach((pacienteEntity) -> {
                    listaPacientes.add(
                            new PacienteDto(pacienteEntity.getPkIdPaciente(),
                                    pacienteEntity.getPacienteNombres() + " " + pacienteEntity.getPacienteApellidos()
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

    @Override
    public int getIdCita() {
        try {
            Query query = em.createQuery("select max(c.pkIdCita) from Cita c ");
            int result = (int) query.getSingleResult();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertCita(int idFuncionario, int idPaciente, Date horaProgramada, Date horaAtencion, String descripcion, boolean aplicaIncapacidad) {
        try {

            int id = getIdCita() + 1;
            Cita c = new Cita();
            c.setPkIdCita(id);
            c.setFkIdFuncionario(idFuncionario);
            c.setFkIdPaciente(idPaciente);
            c.setCitaHoraProgramada(horaProgramada);
            c.setCitaHoraAtencion(horaAtencion);
            c.setCitaDescripcion(descripcion);
            c.setCitaAplicaIncapacidad(aplicaIncapacidad);
            em.persist(c);

            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean deleteCitaPorID(int idCita) {
        Cita citaSeleccionada;
        boolean result = false;

        try {
            citaSeleccionada = em.find(Cita.class, idCita);
            if (citaSeleccionada != null) {
                em.remove(citaSeleccionada);
                result = true;
            }
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public Cita getClientePorID(int id) {
        Cita selected;
        try {
            selected = em.find(Cita.class, id);

            if (selected != null) {
                return selected;
            }
        } catch (NoResultException e) {
            return null;
        }

        if (selected != null) {
            return selected;
        } else {
            return null;
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean updateCitaPorId(int id, Date horaProgramada, Date horaAtencion, String descripcion, boolean aplicaIncapacidad) {
        Cita c;
        try {
            c = em.find(Cita.class, id);
                      
            if (c != null) {
                c.setCitaHoraProgramada(horaProgramada);
                c.setCitaHoraAtencion(horaAtencion);
                c.setCitaDescripcion(descripcion);
                c.setCitaAplicaIncapacidad(aplicaIncapacidad);
                em.merge(c);
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
