/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.ejb.persistentes.Funcionario;
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
    public String insertFuncionario(String nombres, String apellidos, int tipoDocumento, String documento, String correo, String telefono, String contrasena) {
        String rta = "";
        try {
            Funcionario func = em.find(Funcionario.class, Short.parseShort(documento + ""));
            if (func == null) {

//                ciudad.setLastUpdate(fechaActualizacion);
//                ciudad.setCountryId(pais);
//                ciudad.setCity(nombreCiudad);
//                em.merge(ciudad);
                rta = "1,Se actualizo correctamente el registro";

            } else {
                rta = "El Usuario ya Existe!";
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return "";
    }

}
