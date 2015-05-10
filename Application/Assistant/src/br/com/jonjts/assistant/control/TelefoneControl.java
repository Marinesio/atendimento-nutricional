/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.Paciente;
import br.com.jonjts.assistant.entity.Telefone;
import br.com.jonjts.assistant.persistence.TelefonePersistence;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.Collection;
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
    
    public List<Telefone> get(Paciente paciente) throws SQLException{
        QueryBuilder<Telefone, Long> queryBuilder = getPersistence().queryBuilder();
        queryBuilder.where().eq("id_paciente", paciente.getId());
        return queryBuilder.query();
    }
    
    public void delete(Paciente paciente) throws Exception{
        DeleteBuilder<Telefone, Long> deleteBuilder = getPersistence().deleteBuilder();
        deleteBuilder.where().eq("id_paciente", paciente.getId());
        deleteBuilder.delete();
    }

    public void insert(Paciente paciente, Collection<Telefone> collection) throws Exception{
        delete(paciente);
        for(Telefone t : collection){
            t.setPaciente(paciente);
            insert(t);
        }
    }
    
}
