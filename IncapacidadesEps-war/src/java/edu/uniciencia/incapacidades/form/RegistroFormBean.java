/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniciencia.incapacidades.form;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author basto
 */
@ManagedBean
@ApplicationScoped
public class RegistroFormBean {

    String nombresFuncionario, apellidosFuncionario, documentoFuncionario, correoFuncionario, telefonoFuncionario, contrasenaFuncionario;
    int tipoDocumento;

    
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country;  
    private String city;
    private Map<String,String> countries;
    private Map<String,String> cities;
    
    /**
     * Creates a new instance of RegistroFormBean
     */
    public RegistroFormBean() {
        
    }

    public String getNombresFuncionario() {
        return nombresFuncionario;
    }

    public void setNombresFuncionario(String nombresFuncionario) {
        this.nombresFuncionario = nombresFuncionario;
    }

    public String getApellidosFuncionario() {
        return apellidosFuncionario;
    }

    public void setApellidosFuncionario(String apellidosFuncionario) {
        this.apellidosFuncionario = apellidosFuncionario;
    }

    public String getDocumentoFuncionario() {
        return documentoFuncionario;
    }

    public void setDocumentoFuncionario(String documentoFuncionario) {
        this.documentoFuncionario = documentoFuncionario;
    }

    public String getCorreoFuncionario() {
        return correoFuncionario;
    }

    public void setCorreoFuncionario(String correoFuncionario) {
        this.correoFuncionario = correoFuncionario;
    }

    public String getTelefonoFuncionario() {
        return telefonoFuncionario;
    }

    public void setTelefonoFuncionario(String telefonoFuncionario) {
        this.telefonoFuncionario = telefonoFuncionario;
    }

    public String getContrasenaFuncionario() {
        return contrasenaFuncionario;
    }

    public void setContrasenaFuncionario(String contrasenaFuncionario) {
        this.contrasenaFuncionario = contrasenaFuncionario;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String registrar() {
        return "/faces/registro.xhtml?faces-redirect=true";
    }
    
    @PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paulo", "Sao Paulo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
}
