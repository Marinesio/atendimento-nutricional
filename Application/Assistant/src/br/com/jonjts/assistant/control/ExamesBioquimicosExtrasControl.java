/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.ExamesBioquimicosExtras;
import br.com.jonjts.assistant.persistence.ExamesBioquimicosPersistence;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class ExamesBioquimicosExtrasControl implements IControle<ExamesBioquimicosExtras>{
    
    private ExamesBioquimicosPersistence dao;

    private ExamesBioquimicosPersistence getDao() throws SQLException {
        if(dao == null){
            dao = new ExamesBioquimicosPersistence();
        }
        return dao;
    }

    @Override
    public ExamesBioquimicosExtras insert(ExamesBioquimicosExtras object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ExamesBioquimicosExtras> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Number id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ExamesBioquimicosExtras object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExamesBioquimicosExtras get(Number id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
