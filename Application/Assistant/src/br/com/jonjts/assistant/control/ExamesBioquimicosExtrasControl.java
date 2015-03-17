/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.ExamesBioquimicosExtras;
import br.com.jonjts.assistant.persistence.ExamesBioquimicosPersistence;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class ExamesBioquimicosExtrasControl implements IControle<ExamesBioquimicosExtras> {

    private ExamesBioquimicosPersistence dao;

    private ExamesBioquimicosPersistence getDao() throws SQLException {
        if (dao == null) {
            dao = new ExamesBioquimicosPersistence();
        }
        return dao;
    }

    public List<ExamesBioquimicosExtras> insert(List<ExamesBioquimicosExtras> list) throws Exception {
        List<ExamesBioquimicosExtras> extrases = new ArrayList<>();
        for (ExamesBioquimicosExtras extras : list) {
            ExamesBioquimicosExtras insert = insert(extras);
            extrases.add(insert);
        }
        return extrases;
    }

    @Override
    public ExamesBioquimicosExtras insert(ExamesBioquimicosExtras object) throws Exception {
        getDao().create(object);
        return getDao().getLast("id");
    }
    
    @Override
    public List<ExamesBioquimicosExtras> getAll() throws Exception {
        return getDao().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getDao().deleteById(id.longValue());
    }

    @Override
    public void update(ExamesBioquimicosExtras object) throws Exception {
        getDao().update(object);
    }

    @Override
    public ExamesBioquimicosExtras get(Number id) throws Exception {
        return getDao().findById(id.longValue());
    }
    
    public List<ExamesBioquimicosExtras> get(Long idExameClinico) throws SQLException{
        QueryBuilder<ExamesBioquimicosExtras, Long> queryBuilder = getDao().queryBuilder();
        queryBuilder.where().eq("id_exame_clinico", idExameClinico);
        return queryBuilder.query();
    }
    
    public void deleteAll(Long idExameClinico) throws SQLException{
        DeleteBuilder<ExamesBioquimicosExtras, Long> deleteBuilder = getDao().deleteBuilder();
        deleteBuilder.where().eq("id_exame_clinico", idExameClinico);
        deleteBuilder.delete();
    }
    
    public void update(List<ExamesBioquimicosExtras> list, Long idExameClinico) throws Exception{
        deleteAll(idExameClinico);
        insert(list);
    }

}
