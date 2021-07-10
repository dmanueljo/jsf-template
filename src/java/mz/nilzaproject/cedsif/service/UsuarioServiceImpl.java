/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.service;

import java.util.List;
import mz.nilzaproject.cedsif.dao.UsuarioDAO;
import mz.nilzaproject.cedsif.dao.UsuarioDAOImpl;
import mz.nilzaproject.cedsif.model.db.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author nilza.graca
 */
@Component
public class UsuarioServiceImpl implements UsuarioService{

    //@Autowired
    private HibernateTemplate htemplate;
    //injectando a dependencia do service com o userdao
    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(HibernateTemplate htemplate) {
        this.htemplate = htemplate;
        this.usuarioDAO = new UsuarioDAOImpl(htemplate);
    }

    @Override
    public void createOrUpdate(Usuario t) {
        usuarioDAO.createOrUpdate(t);
    }

    @Override
    public Usuario read(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
