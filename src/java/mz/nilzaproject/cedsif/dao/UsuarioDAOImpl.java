/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.nilzaproject.cedsif.dao;

import java.io.Serializable;
import mz.nilzaproject.cedsif.dao.datasource.ArmazemDSImpl;
import mz.nilzaproject.cedsif.model.db.Usuario;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 *
 * @author nilza.graca
 */
public class UsuarioDAOImpl extends ArmazemDSImpl<Usuario, Integer> implements UsuarioDAO{
    
    public UsuarioDAOImpl(HibernateTemplate htemplate) {
        super(htemplate);
    }
    
}
