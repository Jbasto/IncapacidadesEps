/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.EpsDto;
import edu.uniciencia.incapacidades.ejb.persistentes.Eps;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JONATHANB
 */
@Stateless
public class EpsEjbFormBean implements EpsEjbFormBeanLocal {

    @PersistenceContext(unitName = "IncapacidadesEps-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<EpsDto> getListaEps() {
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
                    listEpsDto.add(new EpsDto(epsEntity.getPkIdEps(), epsEntity.getEpsNombre(), epsEntity.getEpsNit()
                    ));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listEpsDto;
    }

    @Override
    public int getIdEps() {
        int result;
        try {
            Query query = em.createQuery("select max(e.pkIdEps) from Eps e ");
            result = (int) query.getSingleResult();
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean insertEps(String nombre, String nit) {
        try {
            int id = getIdEps()+ 1;
            Eps e = new Eps();
            e.setPkIdEps(id);
            e.setEpsNombre(nombre);
            e.setEpsNit(nit);
            em.persist(e);

            return true;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean deleteEpsPorID(int idEps) {
        Eps epsSelect;
        boolean result = false;

        try {
            epsSelect = em.find(Eps.class, idEps);
            if (epsSelect != null) {
                em.remove(epsSelect);
                result = true;
            }
        } catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean updateEpsPorId(int id, String nombre, String nit) {
        Eps e;
        try {
            e = em.find(Eps.class, id);            
            if (e != null) {
                e.setEpsNombre(nombre);
                e.setEpsNit(nit);
                em.merge(e);
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
