/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.control;

import br.com.jonjts.assistant.entity.DadosDieteticos;
import br.com.jonjts.assistant.entity.ExameFisico;
import br.com.jonjts.assistant.entity.Paciente;
import br.com.jonjts.assistant.persistence.DadosDieteticosPersistencia;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class DadosDieteticosControle implements IControl<DadosDieteticos>{
    private DadosDieteticosPersistencia persistencia;

    private DadosDieteticosPersistencia getPersistencia() throws SQLException {
        if(persistencia == null){
            persistencia = new DadosDieteticosPersistencia();
        }
        return persistencia;
    }

    @Override
    public DadosDieteticos insert(DadosDieteticos object) throws Exception {
        synchronized("insert"){
            getPersistencia().persist(object);
            return getPersistencia().getLast("id");
        }
    }

    @Override
    public List<DadosDieteticos> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Number id) throws Exception {
        getPersistencia().deleteById(id.longValue());
    }

    @Override
    public void update(DadosDieteticos object) throws Exception {
        getPersistencia().update(object);
    }

    @Override
    public DadosDieteticos get(Number id) throws Exception {
        return getPersistencia().findById(id.longValue());
    }
    
    public DadosDieteticos get(Long idExameClinico) throws SQLException{
        QueryBuilder<DadosDieteticos, Long> queryBuilder = getPersistencia().queryBuilder();
        queryBuilder.where().eq("id_exame_clinico", idExameClinico);
        return queryBuilder.queryForFirst();
    }
    
}
