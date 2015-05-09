/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.DadosBioquimicos;
import br.com.jonjts.assistant.persistence.DadosDieteticosPersistencia;
import br.com.jonjts.assistant.persistence.DadosQuimicosPersistence;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class DadosBioquimicosControl implements IControl<DadosBioquimicos>{
    
    private DadosQuimicosPersistence dao;

    private DadosQuimicosPersistence getDao() throws SQLException {
        if (dao == null) {
            dao = new DadosQuimicosPersistence();
        }
        return dao;
    }

    @Override
    public DadosBioquimicos insert(DadosBioquimicos object) throws Exception {
        getDao().create(object);
        return getDao().getLast("id");
    }

    @Override
    public List<DadosBioquimicos> getAll() throws Exception {
        return getDao().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getDao().deleteById(id.longValue());
    }

    @Override
    public void update(DadosBioquimicos object) throws Exception {
        getDao().update(object);
    }

    @Override
    public DadosBioquimicos get(Number id) throws Exception {
        return getDao().findById(id.longValue());
    }
    
    public DadosBioquimicos get(Long idExameClinico) throws SQLException{
        QueryBuilder<DadosBioquimicos, Long> queryBuilder = getDao().queryBuilder();
        queryBuilder.where().eq("id_exame_clinico", idExameClinico);
        return queryBuilder.queryForFirst();
    }
}
