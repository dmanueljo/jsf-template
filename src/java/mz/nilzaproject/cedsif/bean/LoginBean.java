/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mz.nilzaproject.cedsif.dao.UsuarioDAO;
import mz.nilzaproject.cedsif.dao.UsuarioDAOImpl;
import mz.nilzaproject.cedsif.model.db.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */

@Component
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable{
    
    
    private Long id;
    private String username;
    private String password;
    private String descricao;

    @Autowired
    HibernateTemplate ht;
    
    UsuarioDAO udao;
    
    @PostConstruct
    public void init(){
        udao = new UsuarioDAOImpl(ht);
        this.username="";
        this.password="";
    }
    
    public LoginBean() {
        
    }

    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Redireciona a tela para o menu
     * @return 
     */
    public String doLogin(){
        
        udao.createOrUpdate(new Usuario(1, "USER", username, password, "EMPTY"));
        
        return "menu";
    }
    
}
