/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.ejb.beans;

import edu.uniciencia.incapacidades.dto.EpsDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JONATHANB
 */
@Local
public interface EpsEjbFormBeanLocal {

    List<EpsDto> getListaEps();

    int getIdEps();

    boolean insertEps(String nombre, String nit);

    boolean deleteEpsPorID(int idEps);

    boolean updateEpsPorId(int id, String nombre, String nit);
}
