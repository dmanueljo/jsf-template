/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import mz.nilzaproject.cedsif.model.db.Material;
import mz.nilzaproject.cedsif.service.ArmazemItemService;
import mz.nilzaproject.cedsif.service.MaterialService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */
@Component
@SessionScoped
@ManagedBean(name="itemBean")
public class ArmazemItemBean implements Serializable {
    
    private static Log LOG = LogFactory.getLog(ArmazemItemBean.class);
    
    private String tipo;
    private String marca;
    private String processador;
    private String referencia;
    private String serialNumber;
    private String anoFabrico;
    
    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private ArmazemItemService itemService;
    
    @Autowired
    HibernateTemplate ht;
    
    public List<String> selectTipoMateriais(){
        
        List<String> materiais = new ArrayList();
        
        return materiais;
    }
    
    public List selectTipoProcessadores(){
        
        List<String> processadores = new ArrayList();
        
        return processadores;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the processador
     */
    public String getProcessador() {
        return processador;
    }

    /**
     * @param processador the processador to set
     */
    public void setProcessador(String processador) {
        this.processador = processador;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the anoFabrico
     */
    public String getAnoFabrico() {
        return anoFabrico;
    }

    /**
     * @param anoFabrico the anoFabrico to set
     */
    public void setAnoFabrico(String anoFabrico) {
        this.anoFabrico = anoFabrico;
    }
    
    public String registarMaterial(){
    
        LOG.info("Registando o matetrial "+tipo+" Tamanho da lista"+ht);
        return "menu"; 
    }
    
    public List<Material> listarMaterial(){
        
        LOG.info("Total de Material"+materialService.list().size());
        return new ArrayList();
    }
    
}
