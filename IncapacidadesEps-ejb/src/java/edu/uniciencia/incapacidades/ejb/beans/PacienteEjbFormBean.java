/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.EpsDto;
import edu.uniciencia.incapacidades.dto.PacienteDto;
import edu.uniciencia.incapacidades.ejb.persistentes.Eps;
import edu.uniciencia.incapacidades.ejb.persistentes.Paciente;
import java.util.ArrayList;
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
public class PacienteEjbFormBean implements PacienteEjbFormBeanLocal {

    @PersistenceContext(unitName = "IncapacidadesEps-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
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
                    String eps = getNombreEps(pacienteEntity.getFkIdEpsPaciente());
                    String tipoDoc = getNombreTipoDocumento(pacienteEntity.getFkIdTipoDocumentoPaciente());

                    listaPacientes.add(
                            new PacienteDto(pacienteEntity.getPkIdPaciente(),
                                    eps,
                                    pacienteEntity.getPacienteNombres(),
                                    pacienteEntity.getPacienteApellidos(),
                                    tipoDoc,
                                    pacienteEntity.getPacienteDocumento()
                            ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String getNombreEps(int idEps) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select E.epsNombre from ");
            sql.append(" Eps e ");
            sql.append(" where e.pkIdEps =:id");
            mapa.put("id", idEps);

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
    public String getNombreTipoDocumento(int idTipoDoc) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select t.tipoDocumentoDescripcion from ");
            sql.append(" TipoDocumento t ");
            sql.append(" where t.pkIdTipoDocumento =:id");
            mapa.put("id", idTipoDoc);

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
    public List<EpsDto> getEps() {
        List<EpsDto> listEpsDto = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT e FROM ");
            sql.append("Eps e ");
            Query query = em.createQuery(sql.toString());
            List<Eps> listaEps = query.getResultList();
            query.getResultList();
            if (!listaEps.isEmpty()) {
                listaEps.forEach((epsEntity) -> {
                    listEpsDto.add(new EpsDto(epsEntity.getPkIdEps(), epsEntity.getEpsNombre()
                    ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listEpsDto;
    }

    @Override
    public int getIdPaciente() {
        try {
            Query query = em.createQuery("select max(p.pkIdPaciente) from Paciente p ");
            int result = (int) query.getSingleResult();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getIdTipoDocumento(String nombre) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select t.pkIdTipoDocumento ");
            sql.append(" from TipoDocumento t ");
            sql.append(" where t.tipoDocumentoDescripcion =:nombre");
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
    public int getIdEps(String nombre) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select e.pkIdEps ");
            sql.append(" from Eps e ");
            sql.append(" where e.epsNombre =:nombre");
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
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertPaciente(String nombre, String apellidos, String tipoDocumento, String documento, String eps) {
        try {
            int id = getIdPaciente() + 1;
            int tipoDocu = getIdTipoDocumento(tipoDocumento);
            int idEps = getIdEps(eps);

            Paciente p = new Paciente();
            p.setPkIdPaciente(id);
            p.setFkIdTipoDocumentoPaciente(tipoDocu);
            p.setFkIdEpsPaciente(idEps);
            p.setPacienteNombres(nombre);
            p.setPacienteApellidos(apellidos);
            p.setPacienteDocumento(documento);
            em.persist(p);

            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean deletePacientePorID(int idCita) {
        Paciente pacienteSelect;
        boolean result = false;

        try {
            pacienteSelect = em.find(Paciente.class, idCita);
            if (pacienteSelect != null) {
                em.remove(pacienteSelect);
                result = true;
            }
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean updatePacientePorId(int id, String nombre, String apellidos, String tipoDoc, String documento, String epsNombre) {
        Paciente p;
        try {
            p = em.find(Paciente.class, id);
            int tipoDocu = getIdTipoDocumento(tipoDoc);
            int idEps = getIdEps(epsNombre);
            
            if (p != null) {
                p.setPacienteNombres(nombre);
                p.setPacienteApellidos(apellidos);
                p.setFkIdTipoDocumentoPaciente(tipoDocu);
                p.setPacienteDocumento(documento);
                p.setFkIdEpsPaciente(idEps);
                em.merge(p);
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
