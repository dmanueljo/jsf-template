/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import mz.nilzaproject.cedsif.model.db.Usuario;
import mz.nilzaproject.cedsif.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.SessionScope;

/**
 *
 * @author nilza.graca
 */

@Component
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable{
    
    /**
     * 
     * Utilizando os Backing Beans, para
     * Fazer as ligacoes dos componentes do JSF renderizados pela HTML
     * e os Controllers
     */
    private HtmlInputText inputUser;
    
    private String link;

    private String pageItem;

     private static Log LOG = LogFactory.getLog(LoginBean.class);
        
    @Inject
    private UsuarioService userService;

    
    
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
        return "menu";
    }

  
    public HtmlInputText getInputUser() {
        return inputUser;
    }

    public void setInputUser(HtmlInputText inputUser) {
        this.inputUser = inputUser;
    }
    
      
    
    /**
     * Redireciona a tela para o menu
     * @return 
     */
    public String doLogin(){
        
        Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        String username = map.get("j_idt5:username");
        String password = map.get("j_idt5:password");
        //FacesServlet servle = Servlet
        try{
            userService.createOrUpdate(new Usuario(1, "ADMIN", username, password, "NI Graca"));
            LOG.info("Button Login Requested. Sending Request to Menu.xhtml"+username+""+password+""+map.keySet());

        }catch(NullPointerException nux){
        
             LOG.info("Button Login Requested. Error"+nux.getLocalizedMessage());
        }
        return "menu";
    }
    
    public String doLogout(){
        
        //userService.createOrUpdate(new Usuario(1, "USER", username, password, "EMPTY"));
        LOG.info("Button Logout Requested. Sending Request to Login.xhtml");
        return "login";
    }

    public String getPageItem() {
        return pageItem;
    }

    public void setPageItem(String pageItem) {
        this.pageItem = pageItem;
    }
    
    
    
    
}
