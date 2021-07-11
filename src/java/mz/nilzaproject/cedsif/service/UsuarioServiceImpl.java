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
import org.springframework.stereotype.Service;

/**
 *
 * @author nilza.graca
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    //@Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public void createOrUpdate(Usuario t) {
        this.usuarioDAO.createOrUpdate(t);
    }

    @Override
    public Usuario read(Integer id) {
       return this.usuarioDAO.read(id);
    }

    @Override
    public Usuario delete(Integer id) {
       return this.usuarioDAO.delete(id);
    }

    @Override
    public List<Usuario> list() {
       return this.usuarioDAO.list();
    }
    
}
