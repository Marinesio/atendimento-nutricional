/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.DadosAntropometricos;
import br.com.jonjts.assistant.entity.ExameClinico;
import br.com.jonjts.assistant.persistence.DadosAntropometricosPersistence;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class DadosAntropometricosControl implements IControl<DadosAntropometricos>{
    
    private DadosAntropometricosPersistence persistence;

    public DadosAntropometricosPersistence getPersistence() throws SQLException {
        if(persistence == null){
            persistence = new DadosAntropometricosPersistence();
        }
        return persistence;
    }

    @Override
    public DadosAntropometricos insert(DadosAntropometricos object) throws Exception {
        getPersistence().create(object);
        return getPersistence().getLast("id");
    }

    @Override
    public List<DadosAntropometricos> getAll() throws Exception {
        return getPersistence().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getPersistence().deleteById(id.longValue());
    }

    @Override
    public void update(DadosAntropometricos object) throws Exception {
        getPersistence().update(object);
    }

    @Override
    public DadosAntropometricos get(Number id) throws Exception {
        return getPersistence().findById(id.longValue());
    }
    
    public DadosAntropometricos get(ExameClinico exameClinico) throws Exception{
        QueryBuilder<DadosAntropometricos, Long> queryBuilder = getPersistence().queryBuilder();
        queryBuilder.where().eq("id_exame_clinico", exameClinico.getId());
        return queryBuilder.queryForFirst();
    }
    
}
