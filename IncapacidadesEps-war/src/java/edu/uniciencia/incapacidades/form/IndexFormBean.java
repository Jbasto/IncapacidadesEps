/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author basto
 */
@Named(value = "indexFormBean")
@ApplicationScoped
@TransactionManagement(TransactionManagementType.CONTAINER)
public class IndexFormBean {

    /**
     * Creates a new instance of indexFormBean
     */
    public IndexFormBean() {
    }
    
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            images.add("salud" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
