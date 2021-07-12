/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import mz.nilzaproject.cedsif.model.db.Usuario;
import mz.nilzaproject.cedsif.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */

@Component("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
    
    private String username;
    private String password;
    private String perfil;
    private String nameDescription;
    
    @ManagedProperty(value="#{menuBean}")
    private String link;
  
    private static Log LOG = LogFactory.getLog(UsuarioBean.class);
    
    @PostConstruct
    public void init(){
        
        username ="";
        password ="";
        perfil  ="";
        nameDescription ="";
    }
    
    @Autowired
    private transient UsuarioService userService;
    
    public String registarUsuario(){
        
        //criar o object usuaruio
        Usuario user = new Usuario(getPerfil(), getUsername(), getPassword(), getNameDescription());
        
        for (Usuario u : this.userService.list()){
            
            //se a conta for igual
            if(u.getUsername().equals(username)){
                
                //pega no usuario
                String message ="Usuario "+getUsername()+" gravado com sucesso"+link;
                
                return "login?faces-redirect=true";  
            }
        }
     
        //invoca um recuros de FacesServlet, para enviar a messagem ao
        //componente de mensagem na tela
        
        //retornar a pagina redirecionada
        return "menu?faces-redirect=true";
        
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the nameDescription
     */
    public String getNameDescription() {
        return nameDescription;
    }

    /**
     * @param nameDescription the nameDescription to set
     */
    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
  
    
}
