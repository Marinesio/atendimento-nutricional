/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.Telefone;
import br.com.jonjts.assistant.persistence.TelefonePersistence;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class TelefoneControl implements IControl<Telefone>{
    
    private TelefonePersistence persistence;

    public TelefonePersistence getPersistence() throws SQLException {
        if(persistence == null){
            persistence = new TelefonePersistence();
        }
        return persistence;
    }

    @Override
    public Telefone insert(Telefone object) throws Exception {
        getPersistence().create(object);
        return getPersistence().getLast("id");
    }

    @Override
    public List<Telefone> getAll() throws Exception {
        return getPersistence().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getPersistence().deleteById(id.longValue());
    }

    @Override
    public void update(Telefone object) throws Exception {
        getPersistence().update(object);
    }

    @Override
    public Telefone get(Number id) throws Exception {
        return getPersistence().findById(id.longValue());
    }
    
    
}
