/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.TipoDocumentoDto;
import edu.uniciencia.incapacidades.ejb.persistentes.Funcionario;
import edu.uniciencia.incapacidades.ejb.persistentes.TipoDocumento;
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
public class FuncionarioEjbFormBean implements FuncionarioEjbFormBeanLocal {

    @PersistenceContext(unitName = "IncapacidadesEps-ejbPU")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean validarFuncionario(String documento, String contrasena) {
        Funcionario fun = null;
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select f from ");
            sql.append(" Funcionario f ");
            sql.append(" where f.funcionarioDocumento =:documento ");
            sql.append(" and f.funcionarioContrasena =:contrasena ");

            if ((documento.length() > 0) && (contrasena.length() > 0)) {
                mapa.put("documento", documento);
                mapa.put("contrasena", contrasena);
            } else {
                return false;
            }

            Query query = em.createQuery(sql.toString());

            for (Map.Entry<String, Object> m : mapa.entrySet()) {
                query.setParameter(m.getKey(), m.getValue());
            }

            List<Funcionario> listaFuncionarios = query.getResultList();

            if (!listaFuncionarios.isEmpty()) {
                fun = listaFuncionarios.get(0);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertFuncionario(String nombres, String apellidos, int tipoDocumento, String documento, String correo, String telefono, String contrasena) {
        try {
            boolean existe = validarDocumento(documento);
            if (!existe) {
                int id = getIdFuncionario() + 1;
                Funcionario f = new Funcionario();
                f.setPkIdFuncionario(id);
                f.setFuncionarioNombres(nombres);
                f.setFuncionarioApellidos(apellidos);
                f.setFkIdTipoDocumentoFuncionario(tipoDocumento);
                f.setFuncionarioDocumento(documento);
                f.setFuncionarioCorreo(correo);
                f.setFuncionarioTelefono(telefono);
                f.setFuncionarioContrasena(contrasena);
                em.persist(f);

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
    public List<TipoDocumentoDto> getTipoDocumento() {
        List<TipoDocumentoDto> listaTipoDocumentoDtos = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT t FROM ");
            sql.append("TipoDocumento t ");
            Query query = em.createQuery(sql.toString());
            List<TipoDocumento> listaTipoDoc = query.getResultList();
            query.getResultList();
            if (!listaTipoDoc.isEmpty()) {
                listaTipoDoc.forEach((paisEntity) -> {
                    listaTipoDocumentoDtos.add(new TipoDocumentoDto(paisEntity.getPkIdTipoDocumento(), paisEntity.getTipoDocumentoDescripcion()));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaTipoDocumentoDtos;
    }

    @Override
    public boolean validarDocumento(String documento) {
        try {
            Map<String, Object> mapa = new HashMap<>();
            StringBuilder sql = new StringBuilder();

            sql.append(" select f from ");
            sql.append(" Funcionario f ");
            sql.append(" where f.funcionarioDocumento =:documento ");

            if (documento.length() > 0) {
                mapa.put("documento", documento);
            } else {
                return false;
            }

            Query query = em.createQuery(sql.toString());

            mapa.entrySet().forEach((m) -> {
                query.setParameter(m.getKey(), m.getValue());
            });

            List<Funcionario> listaFuncionarios = query.getResultList();

            if (!listaFuncionarios.isEmpty()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getIdFuncionario() {
        try {
            Query query = em.createQuery("select max(f.pkIdFuncionario) from Funcionario f ");
            int result = (int) query.getSingleResult();//salary of type long
            
            return result;            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
