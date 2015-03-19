/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.persistence;

import br.com.jonjts.assistant.entity.*;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class TratoGastroIntestinalPersistence extends GenericPersistencia<TratoGastroIntestinal, Long>{

    public TratoGastroIntestinalPersistence() throws SQLException {
        super(DAO.instance().getConnectionSource(), TratoGastroIntestinal.class);
    }
    
}
