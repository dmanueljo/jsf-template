/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */
@Component
@ManagedBean(name="menuBean")
@SessionScoped
public class MenuBean implements Serializable {
    
    //@ManagedProperty(value="#{menuBean}")
    private String link;
    
    private static Log LOG = LogFactory.getLog(MenuBean.class);
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String chooseLink(String link) {
        
        //add parameter dynamically to view
        this.link = link;
        
        LOG.info("Button Link Requested. Selected Link"+this.link);
        return "menu?faces-redirect=true";
    }
    
}
