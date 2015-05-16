/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.persistence;

import br.com.jonjts.assistant.entity.DadosAntropometricos;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class DadosAntropometricosPersistence extends GenericPersistencia<DadosAntropometricos, Long>{

    public DadosAntropometricosPersistence() throws SQLException {
        super(DAO.instance().getConnectionSource() , DadosAntropometricos.class);
    }
}
