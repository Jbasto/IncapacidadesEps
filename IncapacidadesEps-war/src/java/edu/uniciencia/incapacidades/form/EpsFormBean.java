/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import edu.uniciencia.incapacidades.dto.EpsDto;
import edu.uniciencia.incapacidades.ejb.beans.EpsEjbFormBeanLocal;
import edu.uniciencia.incapacidades.ejb.beans.PacienteEjbFormBeanLocal;
import edu.uniciencia.incapacidades.ejb.persistentes.Eps;
import edu.uniciencia.incapacidades.util.PaginationHelper;
import edu.uniciencia.incapacidades.util.Util;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author JONATHANB
 */
@Named(value = "epsFormBean")
@ApplicationScoped
public class EpsFormBean {

    @EJB
    private EpsEjbFormBeanLocal epsEjbFormBean;

    /**
     * Creates a new instance of EpsFormBean
     */
    public EpsFormBean() {
    }

    int pkIdEps;
    String epsNombre, epsNit;
    List<EpsDto> listaEpsDto = new ArrayList<>();
    Eps epsSelect;

    Eps item;
    private int pageSize;
    private int[] page;
    private List dvdCollection;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private DataModel dtmdl = null;
    
    @PostConstruct
    public void init() {
        getListaEpsDto();
        page = new int[]{5, 10, 15, 20, 30, 50};
        pageSize = 10;
    }

    public int getPkIdEps() {
        return pkIdEps;
    }

    public void setPkIdEps(int pkIdEps) {
        this.pkIdEps = pkIdEps;
    }

    public String getEpsNombre() {
        return epsNombre;
    }

    public void setEpsNombre(String epsNombre) {
        this.epsNombre = epsNombre;
    }

    public String getEpsNit() {
        return epsNit;
    }

    public void setEpsNit(String epsNit) {
        this.epsNit = epsNit;
    }

    public List<EpsDto> getListaEpsDto() {
        listaEpsDto = epsEjbFormBean.getListaEps();
        return listaEpsDto;
    }

    public void setListaEpsDto(List<EpsDto> listaEpsDto) {
        this.listaEpsDto = listaEpsDto;
    }

    public Eps getEpsSelect() {
        return epsSelect;
    }

    public void setEpsSelect(Eps epsSelect) {
        this.epsSelect = epsSelect;
    }

    public String registrarEps() {
        if (epsNombre.length() == 0 && epsNit.length() == 0) {

            Util.addErrorMessage("Los datos son obligatorios.");
        } else {

            boolean insert = epsEjbFormBean.insertEps(epsNombre, epsNit);

            if (insert) {
                epsNombre = "";
                epsNit = "";
                Util.addSuccessMessage("Registro Correcto!");
            } else {
                Util.addErrorMessage("Ha ocurrido un error al guardar, inténtelo de nuevo.");
            }
        }
        return null;
    }

    public String borrarEpsPorId(int idEps) {
        if (epsEjbFormBean.deleteEpsPorID(idEps)) {
            return "faces/eps.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String editarEps() {
        if (epsEjbFormBean.updateEpsPorId(epsSelect.getPkIdEps(), epsSelect.getEpsNombre(), epsSelect.getEpsNit())) {
            return "faces/eps.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int[] getPage() {
        return page;
    }

    public void setPage(int[] page) {
        this.page = page;
    }
    
    public int getSize() {
        return listaEpsDto.size();
    }
    
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(this.pageSize, 0) {
                @Override
                public int getItemsCount() {
                    return epsEjbFormBean.count();
                }

                @Override
                public DataModel createPageDataModel() {

                    return new ListDataModel(epsEjbFormBean.findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;

    }

    public DataModel getdtmdl() {
        if (dtmdl == null) {
            dtmdl = getPagination().createPageDataModel();
        }
        return dtmdl;
    }

    private void recreateModel() {
        dtmdl = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    private void updateCurrentItem() {
        int count = epsEjbFormBean.count();
        if (selectedItemIndex >= count) {

            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;

            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            item = epsEjbFormBean.findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "faces/eps.xhtml?faces-redirect=true";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "faces/eps.xhtml?faces-redirect=true";
    }

    //go to the 1st page

    public String firstPage() {
        recreatePagination();
        recreateModel();
        return "faces/eps.xhtml?faces-redirect=true";
    }

    //go to the last page
    public String lastPage() {

        getPagination().setFinalPages();
        recreateModel();
        return "faces/eps.xhtml?faces-redirect=true";
    }

    public String recreatePageSize(AjaxBehaviorEvent e) {
        recreatePagination();
        recreateModel();
        return "faces/eps.xhtml?faces-redirect=true";
    }
}
