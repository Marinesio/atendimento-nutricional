/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.*;
import br.com.jonjts.assistant.persistence.TratoGastroIntestinalPersistence;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.table.DatabaseTable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */

public class TratoGastroIntestinalControl implements IControle<TratoGastroIntestinal>{
    
    private TratoGastroIntestinalPersistence dao;

    private TratoGastroIntestinalPersistence getDao() throws SQLException {
        if(dao == null){
        dao = new TratoGastroIntestinalPersistence();
    }
        return dao;
    }

    @Override
    public TratoGastroIntestinal insert(TratoGastroIntestinal object) throws Exception {
        getDao().create(object);
        return getDao().getLast("id");
    }

    @Override
    public List<TratoGastroIntestinal> getAll() throws Exception {
        return getDao().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getDao().deleteById(id.longValue());
    }

    @Override
    public void update(TratoGastroIntestinal object) throws Exception {
        getDao().update(object);
    }

    @Override
    public TratoGastroIntestinal get(Number id) throws Exception {
        return getDao().findById(id.longValue());
    }
    
    public TratoGastroIntestinal get(Long idExameClinico) throws Exception{
        QueryBuilder<TratoGastroIntestinal, Long> queryBuilder = getDao().queryBuilder();
        queryBuilder.where().eq("id_exame_clinico", idExameClinico);
        return queryBuilder.queryForFirst();
    }
}
