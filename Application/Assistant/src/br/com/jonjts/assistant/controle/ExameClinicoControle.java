/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jonjts.assistant.controle;

import br.com.jonjts.assistant.persistencia.ExameClinicoPersistencia;
import br.com.jonjts.assistant.dto.ExameClinico;
import br.com.jonjts.assistant.dto.Paciente;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class ExameClinicoControle implements IControle<ExameClinico>{
    private ExameClinicoPersistencia exameClinicoDAO;

    private ExameClinicoPersistencia getExameClinicoDAO() throws SQLException {
        if(exameClinicoDAO == null){
            exameClinicoDAO = new ExameClinicoPersistencia();
            return exameClinicoDAO;
        }
        return exameClinicoDAO;
    }

    public ExameClinico getLastConsulta(Long idPaciente) throws SQLException{
        QueryBuilder<ExameClinico, Long> queryBuilder = getExameClinicoDAO().queryBuilder();
        queryBuilder.where().eq("id_paciente", idPaciente);
        return queryBuilder.queryForFirst();
    }
    @Override
    public ExameClinico insert(ExameClinico object) throws Exception {
         synchronized("insert"){
            getExameClinicoDAO().persist(object);
            return getExameClinicoDAO().getLast(Paciente.FILD_ID);
        }
    }

    @Override
    public List<ExameClinico> getAll() throws Exception {
        return getExameClinicoDAO().listAll();
    }

    @Override
    public void delete(Number id) throws Exception {
        getExameClinicoDAO().deleteById(id.longValue());
    }

    @Override
    public void update(ExameClinico object) throws Exception {
        getExameClinicoDAO().update(object);
    }

    @Override
    public ExameClinico get(Number id) throws Exception {
        return getExameClinicoDAO().findById(id.longValue());
    }
    
    public List<ExameClinico> get(Long idPaciente) throws SQLException{
        QueryBuilder<ExameClinico, Long> queryBuilder = getExameClinicoDAO().queryBuilder();
        queryBuilder.where().eq(ExameClinico.FILD_ID_PACIENTE, idPaciente);
        return queryBuilder.query();
    }
    
    
}
