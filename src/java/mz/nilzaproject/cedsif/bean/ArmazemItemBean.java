/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import mz.nilzaproject.cedsif.model.db.ArmazemItem;
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
@Component("itemBean")
@RequestScoped
public class ArmazemItemBean implements Serializable {
    
    private static Log LOG = LogFactory.getLog(ArmazemItemBean.class);
    
    private ArmazemItem item;
    private int itemId;
    
    //private Material material;
    
    private List<String> selectMaterais;
    private List<String> selectTipoProcessadores;
    private List<String> anoFabricoList;

    @Autowired
    private MaterialService materialService;
    
    @Autowired
    private ArmazemItemService itemService;

    public int getitemId() {
        return materialService.list().size() + 1;
    }
    
    @PostConstruct
    public void init(){
        
        selectMaterais = new ArrayList();
        selectTipoProcessadores = new ArrayList();
        anoFabricoList = new ArrayList<>();
    }

    public List<String> getAnoFabricoList() {
        
        for(int i =1;i<8;i++){
            anoFabricoList.add(new String("202"+i));
        }
        
        return anoFabricoList;
    }


    
    public ArmazemItem getItem() {
        return item;
    }

    public void setItem(ArmazemItem item) {
        this.item = item;
    }

    /*
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
   */
    public List<String> getSelectMateriais(){
        
        selectMaterais.add(new String("Laptop"));
        selectMaterais.add(new String("Impressora"));
        selectMaterais.add(new String("Computador"));
        
        return selectMaterais;
    }
    
    public List getSelectTipoProcessadores(){
        
        selectTipoProcessadores.add(new String("Dual Core"));
        selectTipoProcessadores.add(new String("Core i3"));
        selectTipoProcessadores.add(new String("Core i4"));
        selectTipoProcessadores.add(new String("Core i5"));
        
        return selectTipoProcessadores;
    }

       
    public String registarMaterial(){
    
        Material material = new Material(item.getMaterial().getTipo(), 
                item.getMaterial().getMarca(), 
                item.getMaterial().getReferencia(),
                item.getMaterial().getProcessador(),
                item.getMaterial().getSerialNumber(),
                item.getMaterial().getAnoFabrico(), 
                0);
        
        //gravar material
        //materialService.createOrUpdate(material);
        
        ArmazemItem item = new ArmazemItem(material.getId(), Calendar.getInstance().getTime());
        item.setMaterial(material);
        item.setCodigo(material.getId());
        item.setDataLeilao(null);
          
        //gravar
        //this.itemService.createOrUpdate(item);
        
        LOG.info("Registando o matetrial "+material.getMarca()+" Tamanho da lista marca");
        LOG.info("Registando o armazem   "+item.getStatus()   +" Tamanho da lista item");
        
        return "equipamento-registar?faces-redirect=true"; 
    }
    
    public List<ArmazemItem> listarMaterial(){
        
        LOG.info("Total de Material "+itemService.list().size());
        return this.itemService.list();
    }
    
    public String editar(Integer id){
        
        LOG.info("Editando "+itemService.list().size());
        return ""; 
    }
    
    public String deletar(Integer id){
        
        LOG.info("Removendo "+itemService.list().size());
        this.itemService.delete(id);
        
        return "equipamento-listar";
    }
    
}
