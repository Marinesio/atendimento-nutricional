/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.persistence;

import br.com.jonjts.assistant.entity.PlanoSaude;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class PlanoSaudePesistence extends GenericPersistencia<PlanoSaude, Long>{

    public PlanoSaudePesistence() throws SQLException {
        super(DAO.instance().getConnectionSource(), PlanoSaude.class);
    }
    
}
