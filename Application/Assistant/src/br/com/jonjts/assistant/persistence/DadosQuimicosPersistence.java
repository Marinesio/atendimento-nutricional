/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.persistence;

import br.com.jonjts.assistant.entity.DadosBioquimicos;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class DadosQuimicosPersistence extends GenericPersistencia<DadosBioquimicos, Long>{

    public DadosQuimicosPersistence() throws SQLException {
        super(DAO.instance().getConnectionSource(), DadosBioquimicos.class);
    }
    
}
