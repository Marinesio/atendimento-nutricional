/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.persistence;

import br.com.jonjts.assistant.entity.Telefone;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class TelefonePersistence extends GenericPersistencia<Telefone, Long> {

    public TelefonePersistence() throws SQLException {
        super(DAO.instance().getConnectionSource(),Telefone.class);
    }

}
