/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.controle;

import br.com.jonjts.assistant.persistencia.HistoricoClinicoPersistencia;
import br.com.jonjts.assistant.dto.HistoricoClinico;
import br.com.jonjts.assistant.dto.Paciente;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class HistoricoClinicoControle implements IControle<HistoricoClinico>{
    
    private HistoricoClinicoPersistencia historicoClinicoDAO;
    
    public ConnectionSource getConnection() throws SQLException{
        return getHistoricoClinicoDAO().getConnectionSource();
    }

    public HistoricoClinicoPersistencia getHistoricoClinicoDAO() throws SQLException {
        if(historicoClinicoDAO == null){
            return new HistoricoClinicoPersistencia();
        }
        return historicoClinicoDAO;
    }
    
    
    @Override
    public HistoricoClinico insert(HistoricoClinico object) throws Exception {
        synchronized("insert"){
            getHistoricoClinicoDAO().persist(object);
            return getHistoricoClinicoDAO().getLast(Paciente.FILD_ID);
        }
    }

    @Override
    public List<HistoricoClinico> getAll() throws Exception {
        return getHistoricoClinicoDAO().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getHistoricoClinicoDAO().deleteById(id.longValue());
    }

    @Override
    public void update(HistoricoClinico object) throws Exception {
        getHistoricoClinicoDAO().update(object);
    }

    @Override
    public HistoricoClinico get(Number id) throws Exception {
        return getHistoricoClinicoDAO().findById(id.longValue());
    }
    
    
    public HistoricoClinico get(Long idPaciente) throws Exception {
        QueryBuilder<HistoricoClinico, Long> queryBuilder = getHistoricoClinicoDAO().queryBuilder();
        queryBuilder.where().eq(HistoricoClinico.FILD_ID_PACIENTE, idPaciente);
        List<HistoricoClinico> query = queryBuilder.query();
        return query.size() > 0 ? query.get(0) : null;
    }
}
