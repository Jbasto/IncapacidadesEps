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
import edu.uniciencia.incapacidades.ejb.persistentes.EstadoIncapacidad;
import edu.uniciencia.incapacidades.ejb.persistentes.Incapacidad;
import edu.uniciencia.incapacidades.ejb.persistentes.TipoIncapacidad;
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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author basto
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class IncapacidadesEjbFormBean implements IncapacidadesEjbFormBeanLocal {

    @PersistenceContext(unitName = "IncapacidadesEps-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String getTipoIncapacidades(int idTipo) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select t.tipoIncapacidadDescripcion from ");
            sql.append(" TipoIncapacidad t ");
            sql.append(" where t.pkIdTipoIncapacidad =:id");
            mapa.put("id", idTipo);

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
    public String getEstadoIncapacidad(int idEstado) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select e.estadoIncapacidadDescripcion from ");
            sql.append(" EstadoIncapacidad e ");
            sql.append(" where e.pkIdEstadoIncapacidad =:id");
            mapa.put("id", idEstado);

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
    public String getPacienteCita(int idCita) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();
        
            sql.append(" select CONCAT(c.pkIdCita, ' ', p.pacienteNombres, ' ', p.pacienteApellidos) ");
            sql.append(" from Paciente p, Cita c ");
            sql.append(" where c.pkIdCita =:id");
            sql.append(" and c.fkIdPaciente = p.pkIdPaciente ");            
        
            mapa.put("id", idCita);

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
    public List<IncapacidadesDto> getIncapacidades() {
        List<IncapacidadesDto> listaIncapacidadesDtos = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT i FROM ");
            sql.append("Incapacidad i ");
            Query query = em.createQuery(sql.toString());
            List<Incapacidad> listaIncapacidads = query.getResultList();
            if (!listaIncapacidads.isEmpty()) {
                listaIncapacidads.forEach((incapacidadEntity) -> {

                    String tipoIncapcidad = getTipoIncapacidades(incapacidadEntity.getFkIdTipoIncapacidad());
                    String nombrePaciente = getPacienteCita(incapacidadEntity.getFkIdCita());
                    String estadoIncapacidad = getEstadoIncapacidad(incapacidadEntity.getFkIdEstadoIncapacidad());

                    listaIncapacidadesDtos.add(
                            new IncapacidadesDto(incapacidadEntity.getPkIdIncapacidad(),
                                    incapacidadEntity.getIncapacidadFechaInicio(),
                                    incapacidadEntity.getIncapacidadFechaFin(),
                                    nombrePaciente,
                                    tipoIncapcidad,
                                    estadoIncapacidad
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaIncapacidadesDtos;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<PacienteDto> getPacientesCita() {
        List<PacienteDto> listaPacienteCitaDto = new ArrayList<>();
        
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();
        
            sql.append(" select CONCAT(c.pkIdCita, ' ', p.pacienteNombres, ' ', p.pacienteApellidos) ");
            sql.append(" from Paciente p, Cita c ");
            sql.append(" where p.pkIdPaciente = c.fkIdPaciente");
            sql.append(" and c.citaAplicaIncapacidad = 1");
            
            Query query = em.createQuery(sql.toString());
            List<String> listaPacienteCita = query.getResultList();
            
            if (!listaPacienteCita.isEmpty()) {
                listaPacienteCita.forEach((pacienteCitaEntity) -> {                   
                    listaPacienteCitaDto.add(
                            new PacienteDto(pacienteCitaEntity
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaPacienteCitaDto;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<TipoIncapacidadDto> getTipoIncapacidades() {
        List<TipoIncapacidadDto> listaTipoIncapacidadDtos = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT t FROM ");
            sql.append("TipoIncapacidad t ");
            Query query = em.createQuery(sql.toString());
            List<TipoIncapacidad> listaTipoIncapacidad = query.getResultList();
            query.getResultList();
            if (!listaTipoIncapacidad.isEmpty()) {
                listaTipoIncapacidad.forEach((tipoIncapacidadEntity) -> {
                    listaTipoIncapacidadDtos.add(
                            new TipoIncapacidadDto(tipoIncapacidadEntity.getPkIdTipoIncapacidad(),
                                    tipoIncapacidadEntity.getTipoIncapacidadDescripcion(),
                                    tipoIncapacidadEntity.getTipoIncapacidadDuracion()                                    
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaTipoIncapacidadDtos;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<EstadoIncapacidadDto> getEstadoIncapacidades() {
        List<EstadoIncapacidadDto> listaEstadoIncapacidadDtos = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT e FROM ");
            sql.append("EstadoIncapacidad e ");
            Query query = em.createQuery(sql.toString());
            List<EstadoIncapacidad> listaTipoIncapacidad = query.getResultList();
            query.getResultList();
            if (!listaTipoIncapacidad.isEmpty()) {
                listaTipoIncapacidad.forEach((estadoIncapacidadEntity) -> {
                    listaEstadoIncapacidadDtos.add(
                            new EstadoIncapacidadDto(estadoIncapacidadEntity.getPkIdEstadoIncapacidad(),
                                    estadoIncapacidadEntity.getEstadoIncapacidadDescripcion()
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaEstadoIncapacidadDtos;
    }

    @Override
    public int getIdIncapacidad() {
        int result;
        
        try {
            Query query = em.createQuery("select max(i.pkIdIncapacidad) from Incapacidad i ");
            result = (int) query.getSingleResult();

            return result;
        } catch (Exception e) {
            result = 0;            
        }
        
        return result;
    }
    
    @Override
    public int getIdTipoIncapacidad(String nombre) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select t.pkIdTipoIncapacidad ");
            sql.append(" from TipoIncapacidad t ");
            sql.append(" where t.tipoIncapacidadDescripcion =:nombre");
            mapa.put("nombre", nombre);

            Query query = em.createQuery(sql.toString());

            for (Map.Entry<String, Object> m : mapa.entrySet()) {
                query.setParameter(m.getKey(), m.getValue());
            }

            int result = (int) query.getSingleResult();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public int getIdEstadoIncapacidad(String nombre) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select e.pkIdEstadoIncapacidad ");
            sql.append(" from EstadoIncapacidad e ");
            sql.append(" where e.estadoIncapacidadDescripcion =:nombre");
            mapa.put("nombre", nombre);

            Query query = em.createQuery(sql.toString());

            for (Map.Entry<String, Object> m : mapa.entrySet()) {
                query.setParameter(m.getKey(), m.getValue());
            }

            int result = (int) query.getSingleResult();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean insertIncapacidad(Date fechaInicio, Date fechaFin, String tipoIncapacidad, String estadoIncapacidad, String citaPaciente) {
       try {
            int id = getIdIncapacidad() + 1;
            int idTipoIncapcidad = getIdTipoIncapacidad(tipoIncapacidad);
            int idEstadoIncapacidad = getIdEstadoIncapacidad(estadoIncapacidad);
            int idCita = Integer.parseInt(citaPaciente.split(" ")[0]);
                    
            Incapacidad i = new Incapacidad();
            i.setPkIdIncapacidad(id);
            i.setIncapacidadFechaInicio(fechaInicio);
            i.setIncapacidadFechaFin(fechaFin);
            i.setFkIdTipoIncapacidad(idTipoIncapcidad);
            i.setFkIdEstadoIncapacidad(idEstadoIncapacidad);
            i.setFkIdCita(idCita);
            em.persist(i);

            return true;
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean updateIncapacidadPorId(int idIncapacidad, Date fechaInicio, Date fechaFin, String tipoIncapacidad, String estadoIncapacidad, String citaPaciente) {
        Incapacidad i;
        try {
            i = em.find(Incapacidad.class, idIncapacidad);
            
            int idTipoIncapacidad = getIdTipoIncapacidad(tipoIncapacidad);
            int idEstadoIncapacidad = getIdEstadoIncapacidad(estadoIncapacidad);
            int idCita = Integer.parseInt(citaPaciente.split(" ")[0]);
            
            if (i != null) {
                i.setIncapacidadFechaInicio(fechaInicio);
                i.setIncapacidadFechaFin(fechaFin);
                i.setFkIdTipoIncapacidad(idTipoIncapacidad);
                i.setFkIdEstadoIncapacidad(idEstadoIncapacidad);
                i.setFkIdCita(idCita);
                em.merge(i);
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean deleteIncapacidadPorID(int id) {
        Incapacidad incapacidadSelect;
        boolean result = false;

        try {
            incapacidadSelect = em.find(Incapacidad.class, id);
            if (incapacidadSelect != null) {
                em.remove(incapacidadSelect);
                result = true;
            }
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
